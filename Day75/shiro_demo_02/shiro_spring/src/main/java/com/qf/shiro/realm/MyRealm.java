package com.qf.shiro.realm;

import com.qf.shiro.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * Shiro的数据源
 * Shiro通过该Realm对象获知：
 * 1）当前用户的用户名和密码是否合法
 * 2）当前这个用户有哪些权限和角色
 */
@Component
public class MyRealm extends AuthorizingRealm {

    /**
     * 该方法用于告诉shiro当前登录用户的授权信息（权限、角色）
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //拿到登录者
        User user = (User) principals.getPrimaryPrincipal();

        //管理权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        if(user.getUsername().equals("admin")){
            //admin - query add
            simpleAuthorizationInfo.addStringPermission("/query");
            simpleAuthorizationInfo.addStringPermission("/add");
        } else if(user.getUsername().equals("root")){
            //root - query delete update
            simpleAuthorizationInfo.addStringPermission("/query");
            simpleAuthorizationInfo.addStringPermission("/delete");
            simpleAuthorizationInfo.addStringPermission("/update");
        }

        return simpleAuthorizationInfo;
    }

    /**
     * 该方法用于告诉shiro当前用户输入的用户名和密码是否合法
     *
     * 一般的做法，在这个方法中调用service查询数据库
     *
     * 正确的用户：
     * admin 123456 小红
     * root 111111 小明
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        User user = null;

        //获得当前登录用户的用户名和密码
        String username = (String) token.getPrincipal();//获得当前输入的用户名
        if(username.equals("admin")){
            user = new User("admin", "123456", "小红");
        } else if(username.equals("root")){
            user = new User("root", "111111", "小明");
        }

        if(user != null) {
            /**
             * 三个参数：
             * 第一个参数：登录成功后，放入session中的值
             * 第二个参数：正确的密码
             * 第三个参数：realm的名称
             */
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());

            return authenticationInfo;
        }

        return null;
    }
}

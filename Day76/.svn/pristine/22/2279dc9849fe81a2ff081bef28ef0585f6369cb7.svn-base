package com.qf.oa.realm;

import com.qf.oa.entity.Employee;
import com.qf.oa.entity.Resc;
import com.qf.oa.service.IEmpService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Shiro的数据源
 */
@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IEmpService empService;


    /**
     * 权限控制 - 每次验证权限时都会调用
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Employee employee = (Employee) principals.getPrimaryPrincipal();

        //从职工对象中直接获得权限列表
        List<Resc> rescs = employee.getRescs();

        if(rescs != null){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            for (Resc resc : rescs) {
                if(resc.getRpath() != null && !"".equals(resc.getRpath())) {
                    simpleAuthorizationInfo.addStringPermission(resc.getRpath());
                }
            }
            return simpleAuthorizationInfo;
        }

        return null;
    }

    /**
     * 身份认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获得登录时的用户名
        String email = (String) token.getPrincipal();
        //通过邮箱查询用户信息
        Employee employee = empService.queryByEmail(email);

        if(employee != null){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(employee, employee.getPassword(), this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}

package com.qf.oa.util;

import com.qf.oa.entity.Employee;
import io.rong.RongCloud;
import io.rong.messages.TxtMessage;
import io.rong.methods.message._private.Private;
import io.rong.methods.user.User;
import io.rong.models.message.PrivateMessage;
import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;

/**
 * 融云的工具类
 */
public class IMUtils {

    private static final String appKey = "qf3d5gbjqhruh";
    private static final String appSecret = "xQbvnQb9uhwI";

    private static RongCloud rongCloud;

    static {
        rongCloud = RongCloud.getInstance(appKey, appSecret);
    }

    /**
     * 将信息注册到融云服务器上
     *
     * 将职工的id注册到融云服务器上
     *
     * 职工id - token 的关联
     *
     * @param employee
     * @return
     */
    public static String registerToken(Employee employee){
        User User = rongCloud.user;

        /**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#register
         *
         * 注册用户，生成用户在融云的唯一身份标识 Token
         */
        UserModel user = new UserModel()
                .setId(employee.getId() + "")
                .setName(employee.getName())
                .setPortrait("http://www.rongcloud.cn/images/logo.png");
        TokenResult result = null;
        try {
            result = User.register(user);
        } catch (Exception e) {
            return null;
        }
        return result.getToken();
    }

    /**
     * from 给 to 发送消息
     * @param fromid
     * @param toid
     * @param content
     */
    public static boolean sendMsg(String fromid, String content, String... toid){
        //或私聊对象
        Private msgPrivate = rongCloud.message.msgPrivate;

        TxtMessage txtMessage = new TxtMessage(content, null);

        //私聊的消息对象
        PrivateMessage privateMessage = new PrivateMessage();
        privateMessage.setTargetId(toid);//接受者的id
        privateMessage.setSenderId(fromid);//发送者的id
        privateMessage.setContent(txtMessage);
        privateMessage.setObjectName(txtMessage.getType());

        try {
            msgPrivate.send(privateMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}

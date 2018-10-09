package com.qf.main;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 发送邮件
 * 1、创建一个邮件对象
 * 2、获得发送方服务器的链接对象
 */
public class Main {

    public static void main(String[] args) throws Exception {

        //配置文件 -> properties对象
        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("mail.properties"));
        Session session = Session.getDefaultInstance(properties);

        //创建邮件
        MimeMessage mimeMessage = createMail(session);

        //通过session获得smtp服务器的链接对象
        Transport transport = session.getTransport();

        //开始链接服务器
        transport.connect(properties.getProperty("mail.username"), properties.getProperty("mail.password"));

        //发送邮件
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

        transport.close();
    }


    /**
     * 创建邮件
     */
    private static MimeMessage createMail(Session session) throws Exception {

        //基于session创建一封邮件
        MimeMessage mimeMessage = new MimeMessage(session);

        //设置发送方
        mimeMessage.setFrom(new InternetAddress("verygoodwlk@sina.cn", "腾讯客服"));

        //设置接收方
        //普通的接受对方（这封邮件的直接对象是谁） - Message.RecipientType.TO
        //抄送方（本身和邮件的内容没有直接关系，但是需要知道这封邮件的存在） - Message.RecipientType.CC
        //密送方（其他人看不到这个人接收了邮件）- Message.RecipientType.BCC
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("1120673996@qq.com", "金牌会员"));

        //设置标题
        mimeMessage.setSubject("会员续费通知！！！", "utf-8");

        //设置内容
//        mimeMessage.setText("亲，您的会员即将到期，请进行续费！！！   <a href=\"http://www.baidu.com\">百度</a>", "utf-8");
        mimeMessage.setContent("亲，您的会员即将到期，请进行续费！！！   <a href=\"http://www.baidu.com\">百度</a>", "text/html;charset=utf-8");


        //设置发送时间
        mimeMessage.setSentDate(new Date());

        //保存邮件对象
        mimeMessage.saveChanges();

        return mimeMessage;
    }
}

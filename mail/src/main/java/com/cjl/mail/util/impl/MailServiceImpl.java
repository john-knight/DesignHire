package com.cjl.mail.util.impl;

import com.cjl.mail.util.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
/**
* @Description:    发送邮件
* @Author:         cjl
* @CreateDate:     2020/3/25 23:12
* @UpdateUser:
* @UpdateDate:     2020/3/25 23:12
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class MailServiceImpl implements MailService {
    private final Logger logger =LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private  String from;
    @Value("${mail.text.prefix}")
    private  String prefix;
    @Value("${mail.text.suffix}")
    private  String suffix;
    @Value("${mail.text.content}")
    private String content;
    @Override
    public void sendSimpleMail(String to,String name,String code) {
        String subject = prefix+name+suffix+code;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            javaMailSender.send(message);
            logger.info("发送成功");
        }
        catch (Exception e){
           logger.error("发送失败");
        }
    }
}

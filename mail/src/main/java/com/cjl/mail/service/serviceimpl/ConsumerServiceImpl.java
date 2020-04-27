package com.cjl.mail.service.serviceimpl;


import com.cjl.mail.service.ConsumerService;
import com.cjl.mail.util.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
/**
 * @Description: 此类为监听任务，使用Mailservice处理来自ActiveMq的消息
 * @Author: cjl
 * @CreateDate: 2020/3/29 16:29
 * @UpdateUser:
 * @UpdateDate: 2020/3/29 16:29
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    MailServiceImpl mailService;

    // 使用JmsListener配置消费者监听的队列，其中name是接收到的消息
    @JmsListener(destination = "ActiveMQQueue")
    // SendTo 会将此方法返回的数据, 写入到 OutQueue 中去.
    @SendTo("SQueue")
    @Override
    /**
     * 处理消息队列的信息
     */
    public void handleMessage(String txt) {
        String to = txt.substring(0, txt.indexOf("+"));
        String name = txt.substring(txt.indexOf("+") + 1, txt.indexOf("#"));
        String code = txt.substring(txt.indexOf("#") + 1, txt.length());
        mailService.sendSimpleMail(to, name, code);


    }
}

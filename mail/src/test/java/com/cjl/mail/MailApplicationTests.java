package com.cjl.mail;

import com.cjl.mail.util.impl.MailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailApplicationTests {
@Autowired
MailServiceImpl mailServiceImpl;
    @Test
    void contextLoads() {
        int newNum = (int)((Math.random()*9+1)*100000);
        mailServiceImpl.sendSimpleMail("2643737814@qq.com","张帆",String.valueOf(newNum));
    }

}

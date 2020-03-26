package com.cjl.mail.controller;

import com.cjl.mail.util.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
/**
 * @Description: 为邮件系统提供HTTP服务
 * @Author: cjl
 * @CreateDate: 2020/3/25 22:58
 * @UpdateUser:
 * @UpdateDate: 2020/3/25 22:58
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MailController {
    @Autowired
    private MailServiceImpl mailServiceImpl;
    @RequestMapping(value = "send_email")
    public String sendEmail(String to, String name, String code) {
       try {
           mailServiceImpl.sendSimpleMail(to,name,code);
       }catch (Exception e){
           return "FAIL";
       }
       return "SUCCESS";
    }
}

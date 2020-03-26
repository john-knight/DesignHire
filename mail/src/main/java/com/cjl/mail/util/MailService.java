package com.cjl.mail.util;
/**
* @Description:    邮件系统处理类
* @Author:         cjl
* @CreateDate:     2020/3/25 22:56
* @UpdateUser:
* @UpdateDate:     2020/3/25 22:56
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface MailService {
    /**
     *  发送邮件
     * @param to 接收方邮件
     * @param name  接收方姓名
     * @param code  接收方验证码
     */
    void sendSimpleMail(String to,String name,String code);
}

package com.nakir.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    private MailSender mail;

    public void sendEmail(String toAddress, String msgBody) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("springchattest@gmail.com");
        msg.setTo(toAddress);
        msg.setSubject("SpringChat!");
        msg.setText(msgBody);
        mail.send(msg);
    }
}

package com.aptest.mail;

import com.aptest.document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;
    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendAccountCreationConfirmation(User user){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("aptest : Account creation successful");
        message.setText("Dear "+ user.getFirstName()+
                "\n\n"+
                "Account creation was successful. PLease login on the application to access your account. "+
                "\n\n"+
                "Regards aptest Customer Care");

        javaMailSender.send(message);
    }
}

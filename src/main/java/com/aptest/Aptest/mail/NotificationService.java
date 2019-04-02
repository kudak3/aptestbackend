package com.aptest.Aptest.mail;

import com.aptest.Aptest.document.Student;
import com.aptest.Aptest.document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
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
        message.setSubject("Aptest : Account creation successful");
        message.setText("Dear "+ user.getFirstName()+
                "\n\n"+
                "Account creation was successful. PLease login on the application to access your account. "+
                "\n\n"+
                "Regards Aptest Customer Care");

        javaMailSender.send(message);
    }
}

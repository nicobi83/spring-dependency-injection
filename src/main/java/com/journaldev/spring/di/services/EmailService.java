package com.journaldev.spring.di.services;


import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.inject.Named;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by NICOLA on 24/06/2016.
 */
@Named
public class EmailService implements MessageService {

    private JavaMailSender mailSender;
    //private SimpleMailMessage templateMessage;


    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    //public void setTemplateMessage(SimpleMailMessage templateMessage) {this.templateMessage = templateMessage;}

    public boolean sendMessage(String msg, String mailaddress) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setTo( mailaddress );
            helper.setText( msg, true );
            mailSender.send( message );
        }
        catch (MailException e) {
            System.err.println(e.getMessage());
        } catch (MessagingException e) {
            Logger.getLogger( EmailService.class.getName() ).log(Level.SEVERE, null,e);
        }

        return true;
    }
}

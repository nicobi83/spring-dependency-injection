package com.journaldev.spring.di.services;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by NICOLA on 24/06/2016.
 */
public class EmailService implements MessageService {

    private MailSender mailSender;
    private SimpleMailMessage templateMessage;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    public boolean sendMessage(String msg, String rec) {

        SimpleMailMessage mail = new SimpleMailMessage( this.templateMessage );
        mail.setText( "E-mail sent to " + rec + " with message " + msg );

        try {
            this.mailSender.send( mail );
        }
        catch (MailException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("E-mail sent to " + rec + " with message " + msg);
        return true;
    }
}

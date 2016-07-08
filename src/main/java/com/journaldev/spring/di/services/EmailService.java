package com.journaldev.spring.di.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import javax.inject.Named;

/**
 * Created by NICOLA on 24/06/2016.
 */
@Named
public class EmailService implements MessageService {

    Logger logger = LoggerFactory.getLogger( EmailService.class );

    private MailSender mailSender;
    public void setMailSender(MailSender mailSender) {

        this.mailSender = mailSender;

    }

    private SimpleMailMessage templateMessage;
    public SimpleMailMessage getTemplateMessage() {

        if(this.templateMessage == null)  {
            this.templateMessage = new SimpleMailMessage();
            this.templateMessage.setSubject("Test - template");
            this.templateMessage.setFrom("n.b@gmail.com");
            this.templateMessage.setText("tesst test");
            this.templateMessage.setTo("mcb@gmail.com");
        }
        return templateMessage;
    }
    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    public boolean sendMessage(String msg, String mailaddress) {

            SimpleMailMessage message = new SimpleMailMessage( this.getTemplateMessage() );
            message.setText( "Hello!" );

        try{
           this.mailSender.send( message );
        }catch(MailException e){
            logger.error( e.getMessage() );
        }
        
        return true;
    }
}

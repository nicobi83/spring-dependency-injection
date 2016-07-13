package com.journaldev.spring.di.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import javax.inject.Named;
import java.util.Properties;

/**
 * Created by NICOLA on 24/06/2016.
 */
@Named
public class EmailService implements MessageService {

    Logger logger = LoggerFactory.getLogger( EmailService.class );
    Properties prop = new Properties(System.getProperties());

    private MailSender mailSender;
    public void setMailSender(MailSender mailSender) {

        this.mailSender = mailSender;

    }

    private SimpleMailMessage templateMessage;
    public SimpleMailMessage getTemplateMessage() {

        if(this.templateMessage == null)  {
                setTemplateMessage(templateMessage);
                logger.info(this.templateMessage.getFrom());
                logger.info(this.templateMessage.getReplyTo());
                logger.info(this.templateMessage.getSubject());
                logger.info(this.templateMessage.getText());
        }
        return templateMessage;
    }
    public void setTemplateMessage(SimpleMailMessage templateMessage) {

        this.templateMessage = new SimpleMailMessage();
        this.templateMessage.setSubject( prop.getProperty("email.subject") );
        this.templateMessage.setFrom( prop.getProperty("email.from") );
        this.templateMessage.setText( prop.getProperty("email.text") );
        this.templateMessage.setTo( prop.getProperty("email.to") );

    }

    public boolean sendMessage(String msg, String mailaddress) {

            SimpleMailMessage message = new SimpleMailMessage( this.getTemplateMessage() );
            message.setText( "Hello!" );

        try{
           this.mailSender.send( message );
        }catch(MailException e){
            logger.error( e.getLocalizedMessage() );
        }

        return true;
    }
}

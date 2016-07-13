package com.journaldev.spring.di.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import javax.inject.Named;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by NICOLA on 24/06/2016.
 */
@Named
public class EmailService implements MessageService {

    Logger logger = LoggerFactory.getLogger( EmailService.class );
    Properties prop = new Properties(System.getProperties());
    InputStream in = null;
    SimpleMailMessage templateMessage = new SimpleMailMessage();

    private MailSender mailSender;
    public void setMailSender(MailSender mailSender) {

        this.mailSender = mailSender;

    }

    public SimpleMailMessage getTemplateMessage() {

        if(this.templateMessage == null)  {
                this.templateMessage = new SimpleMailMessage();
                setTemplateMessage(templateMessage);
                logger.info(this.templateMessage.getFrom());
                logger.info(this.templateMessage.getReplyTo());
                logger.info(this.templateMessage.getSubject());
                logger.info(this.templateMessage.getText());
        }
        return templateMessage;
    }
    public void setTemplateMessage(SimpleMailMessage templateMessage) {

        try {
            in = new FileInputStream("email.properties");
            prop.load(in);
            this.templateMessage.setFrom( prop.getProperty("email.from") );
            this.templateMessage.setTo( prop.getProperty("email.to") );
            this.templateMessage.setSubject( prop.getProperty("email.subject") );
            this.templateMessage.setText( prop.getProperty("email.text") );

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

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


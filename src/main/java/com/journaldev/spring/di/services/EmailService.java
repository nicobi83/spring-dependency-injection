package com.journaldev.spring.di.services;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * Created by NICOLA on 24/06/2016.
 */
@Named
public class EmailService implements MessageService {

    private MailSender mailSender;
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public SimpleMailMessage getTemplateMessage() {
        return templateMessage;
    }

    private SimpleMailMessage templateMessage;
    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }


    public boolean sendMessage(String msg, String mailaddress) {

            SimpleMailMessage message = new SimpleMailMessage( templateMessage );
            message.setTo( "bombonati.nicola@gmail.com" );
            message.setFrom( "nicovolante83@gmail.com" );
            message.setSubject( "This is the test message for testing gmail smtp server using spring mail." );
            message.setText( "Hello!" );

        try{
           this.mailSender.send( message );
        }catch(MailException e){
            Logger.getLogger( e.getMessage() );
        }

        return true;
    }
}

package com.journaldev.spring.di.services;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Created by NICOLA on 24/06/2016.
 */
public interface MessageService {

    public boolean sendMessage(String msg, String mailaddress );

}

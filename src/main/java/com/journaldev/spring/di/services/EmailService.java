package com.journaldev.spring.di.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by NICOLA on 24/06/2016.
 */
public class EmailService implements MessageService {
    public boolean sendMessage(String msg, String rec) {

        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("E-mail sent to " + rec + "with message " + msg);
        return true;
    }
}

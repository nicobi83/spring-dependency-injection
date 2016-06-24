package com.journaldev.spring.di.services;

import java.util.logging.Logger;

/**
 * Created by NICOLA on 24/06/2016.
 */
public class EmailService implements MessageService {
    public boolean sendMessage(String msg, String rec) {
        Logger logger = new Logger();
        logger.info("E-mail sent to " + rec + "with message " + msg);
        return true;
    }
}

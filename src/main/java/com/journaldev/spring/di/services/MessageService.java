package com.journaldev.spring.di.services;

/**
 * Created by NICOLA on 24/06/2016.
 */
public interface MessageService {

    public boolean sendMessage(String msg, String mailaddress);

}

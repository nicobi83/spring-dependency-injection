package com.journaldev.spring.di.services;

/**
 * Created by NICOLA on 27/06/2016.
 */
public class TwitterService implements MessageService {
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Twitter message Sent to " +  rec + "The message is " + msg );
        return true;
    }
}

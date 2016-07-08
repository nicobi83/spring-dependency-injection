package com.journaldev.spring.di.consumer;

import com.journaldev.spring.di.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by NICOLA on 27/06/2016.
 */
@Component
public class MyApplication {

    private MessageService service;

    @Autowired
    public void setService(MessageService svc){
        this.service=svc;
    }

    public boolean processMessage( String msg, String mailaddress )
    {
        return this.service.sendMessage(msg, mailaddress);
    }

}

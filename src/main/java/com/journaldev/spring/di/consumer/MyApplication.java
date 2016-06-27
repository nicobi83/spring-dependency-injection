package com.journaldev.spring.di.consumer;

import com.journaldev.spring.di.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by NICOLA on 27/06/2016.
 */
@Component
public class MyApplication {

    //field-based dependency injection (1)
    //@Autowired
    private MessageService service;

//	constructor-based dependency injection (2)
//	@Autowired
//	public MyApplication(MessageService svc){
//		this.service=svc;
//	}

    @Autowired
    public void setService(MessageService svc){
        this.service=svc;
    }

    public boolean processMessage( String msg, String src )
    {
        return this.service.sendMessage(msg, src);
    }

}


//L'annotazione @Autowired serve ad implementare la dependency injection del metodo definito nel componente.
//@Autowired può essere applicato, oltre che ad un METODO, anche ad un parametro ( vedi (1) ) e ad un costruttore ( vedi (2) )

//L'annotaziore @Component si applica sopra una classe e soltanto ad una classe; alla scansione SpringFrameWork considera
// componenti tutte le classi a cui è stata applicata l'annotazione @Component.
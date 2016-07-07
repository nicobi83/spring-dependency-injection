package com.journaldev.spring.di.test;

import com.journaldev.spring.di.configuration.DIConfiguration;
import com.journaldev.spring.di.consumer.MyApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by NICOLA on 27/06/2016.
 */

public class ClientApplication {

    public static void main( String[] args )
    {
        Logger logger = LoggerFactory.getLogger(ClientApplication.class);
        logger.info("E-mail sent to with message");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DIConfiguration.class );
        MyApplication app = context.getBean( MyApplication.class );
        app.processMessage( "Ciao questo è un messaggio di prova", "bombonati.nicola@gmail.com" );
        context.close();
        System.exit(0); //1
}

}
/*
*  1. The instruction "System.exit(0)" solves "ERROR: JDWP Unable to get JNI 1.2 environment" issue.
* */
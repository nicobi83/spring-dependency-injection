package com.journaldev.spring.di.test;

import com.journaldev.spring.di.configuration.DIConfiguration;
import com.journaldev.spring.di.consumer.MyApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by NICOLA on 27/06/2016.
 */

public class ClientApplication {

    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DIConfiguration.class );
        MyApplication app = context.getBean( MyApplication.class );
        app.processMessage( "Ciao questo è un messaggio di prova", "bombonati.nicola@gmail.com" );
        context.close();
    }

}

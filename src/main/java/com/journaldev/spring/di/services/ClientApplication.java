package com.journaldev.spring.di.services;

import com.journaldev.spring.di.configuration.DIConfiguration;
import com.journaldev.spring.di.consumer.MyApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by NICOLA on 27/06/2016.
 */

public class ClientApplication {

    public static void main( String[] args )
    {
        Properties properties = new Properties( System.getProperties() );
        try{
            InputStream emailPropertiesStream = ClientApplication.class.getResourceAsStream( "/email.properties" );
            properties.load( emailPropertiesStream );
        }catch(IOException e){
            Logger logger = LoggerFactory.getLogger(ClientApplication.class);
            e.printStackTrace();
        }
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DIConfiguration.class );
        MyApplication app = context.getBean( MyApplication.class );
        app.processMessage( "Ciao questo è un messaggio di prova", "bombonati.nicola@gmail.com" );
        context.close();
    }
}

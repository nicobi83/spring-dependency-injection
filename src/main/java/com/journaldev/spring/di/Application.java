package com.journaldev.spring.di;

import com.journaldev.spring.di.configuration.DIConfiguration;
import com.journaldev.spring.di.model.Person;
import com.journaldev.spring.di.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by NICOLA on 27/06/2016.
 */

public class Application {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Application.class);
        Properties properties = new Properties(System.getProperties());
        Person person = new Person();
        ApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        PersonService personService = context.getBean(PersonService.class);
        personService.setPerson(person);
        personService.getPerson();

        /*try {
            InputStream emailPropertiesStream = Application.class.getResourceAsStream("/email.properties");
            properties.load(emailPropertiesStream);

        } catch (IOException e) {
            logger.error("exception launched");
            e.printStackTrace();
        }*/

    }
}

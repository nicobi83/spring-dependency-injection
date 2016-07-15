package com.journaldev.spring.di;

import com.journaldev.spring.di.configuration.DIConfiguration;
import com.journaldev.spring.di.model.Person;
import com.journaldev.spring.di.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by NICOLA on 27/06/2016.
 */

public class Application {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Application.class);
        Person person = new Person();
        logger.debug("I'M VERIFYING APPLICATION BEAN SERVICE....");
        ApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        logger.info("ALL OK, APPLICATION IS STARTED!!");
        PersonService personService = context.getBean(PersonService.class);
        personService.setPerson(person);
        personService.getPerson();


    }
}

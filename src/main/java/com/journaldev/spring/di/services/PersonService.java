package com.journaldev.spring.di.services;

import com.journaldev.spring.di.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by NICOLA on 14/07/2016.
 */
public class PersonService {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    Person person;
    Properties prop = new Properties( System.getProperties() );
    InputStream in;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {


        in = getClass().getResourceAsStream("/person.porperties");
        try {
            prop.load(in);
            person.setName( prop.getProperty("person.name") );
            person.setSurname( prop.getProperty( "person.surname" ) );
            person.setCountry( prop.getProperty( "person.country" ) );
            person.setNationality( prop.getProperty( "person.nationality" ) );

        } catch (IOException e) {
            logger.error("ERROR!! File not found", e.getCause().toString() );
            e.printStackTrace();
        }finally {
            try {
                in.close();
                logger.info("Person initialization completed successfully!!");
            } catch (IOException e) {
                logger.error("Error in initialization", e.getCause().toString() );
                e.printStackTrace();
            }
        }

        this.person = person;
    }
}

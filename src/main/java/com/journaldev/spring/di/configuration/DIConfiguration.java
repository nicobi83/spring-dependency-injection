package com.journaldev.spring.di.configuration;

import com.journaldev.spring.di.services.EmailService;
import com.journaldev.spring.di.services.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by NICOLA on 27/06/2016.
 */
@Configuration
public class DIConfiguration {

    @Bean
    public MessageService getMessageService()
        {
            return new EmailService();
        }

}

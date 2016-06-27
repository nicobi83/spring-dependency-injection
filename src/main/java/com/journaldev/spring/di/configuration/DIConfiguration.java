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
@ComponentScan
public class DIConfiguration {

    @Bean
    public MessageService getMessageService()
        {
            return new EmailService();
        }

}



//@ComponentScan si usa soltanto laddove la classe è stata definita come classe di configurazione o bean
//di configurazione, cosa possibile usando l'annotazione @Configuration.
//Con "value" dentro @ComponentScan indichiamo il punto dove il framework deve andare a cercare i componenti.

//Con @Bean definisco il metodo che prende l'implementazione del componente da iniettare dentro la classe con @Component
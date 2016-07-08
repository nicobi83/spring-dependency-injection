package slf4jTest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by NICOLA on 07/07/2016.
 */

public class TestSlf4j {

    Logger logger = LoggerFactory.getLogger(TestSlf4j.class);
    String s;
    Boolean bool;


    @Test
     public void Hello() {


            logger.info("Hello World");
            logger.info("ciao", logger, s);
            logger.error("this is an error");
            logger.debug("DEBUG!!");
            bool = logger.isTraceEnabled();
            logger.info( bool.toString() );
            logger.warn("ATTENZIONE!!");
            s = logger.getName();
            logger.info( s );
            logger.trace( "Hello TRACE" );

     }

    @Test
    public void Temperature_misuration() {

        Integer t = 30;
        Integer oldT;
        Integer temperature = 60;

        oldT = t;
        t = temperature;

        logger.debug( "Temperature set to {}. Previous temperature was {}", t, oldT );
        if (temperature.intValue() > 50) {
            logger.info ( "50 Celsius degree reached!!" );
        }
    }
}


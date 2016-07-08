package slf4jTest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by NICOLA on 07/07/2016.
 */

public class TestSlf4j {

    Logger logger = LoggerFactory.getLogger(TestSlf4j.class);
    Boolean bool;


    @Test
     public void Hello() {

            logger.info("Hello World");
            logger.error("this is an ERROR");
            logger.debug("DEBUG!!");
            logger.warn("ATTENZIONE!!");
            logger.info( logger.getName() );
            bool = logger.isTraceEnabled();
            logger.info( bool.toString() );
            logger.trace( "This is a TRACE" );
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


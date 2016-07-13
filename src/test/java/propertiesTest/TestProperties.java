package propertiesTest;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by NICOLA on 11/07/2016.
 */
public class TestProperties {

    Logger logger = LoggerFactory.getLogger(TestProperties.class);
    Properties prop = new Properties();
    OutputStream out = null;
    InputStream in = null;
    InputStream in2 = null;

    @Test
    public void writeProperties() {

        String comments = "This is only a property file!";

        try {

            String filename = "config.properties";
            out = new FileOutputStream(filename);
            prop.setProperty("textcolor", "Green");
            prop.setProperty("textfont", "Arial");
            prop.store(out, comments);

        } catch (FileNotFoundException e) {
            logger.error("ERROR!! File not created");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void loadProperties() {

        try {
            in = new FileInputStream("src\\test\\resources\\application.properties");
            prop.load(in);
            logger.info(prop.getProperty("logging.level"));
            logger.info(prop.getProperty("logging.file"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void loadPropFromClasspath() {

        try {

            in = getClass().getClassLoader().getResourceAsStream("application.properties");
            in2 = getClass().getResourceAsStream("config.properties");
            if (in == null) {
                logger.error("ERROR!!!! File not present");
                return;
            }
            if (in2 == null) {
                logger.error("ERROR!!!! File not present");
                return;
            }
            prop.load(in);
            prop.load(in2);
            logger.info(prop.getProperty("logging.level"));
            logger.info(prop.getProperty("logging.file"));
            logger.info(prop.getProperty("textfont"));
            logger.info(prop.getProperty("textcolor"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null && in !=null) {
                try {
                    in.close();
                    in2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

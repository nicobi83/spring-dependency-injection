package propertiesTest;

import com.journaldev.spring.di.model.Person;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.Properties;

/**
 * Created by NICOLA on 11/07/2016.
 */
public class TestProperties {

    Logger logger = LoggerFactory.getLogger(TestProperties.class);
    Properties prop = new Properties(System.getProperties());
    OutputStream out = null;
    InputStream in = null;
    InputStream in2 = null;
    public SimpleMailMessage templateMessage = new SimpleMailMessage();
    Person person = new Person();
    ServerConfig config = ConfigFactory.create(ServerConfig.class);


    @Test
    public void writeProperties() {

        String comments = "This is only a property file!";

        try {

            String filename = "src\\main\\resources\\config.properties";
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
                    logger.info("FILE SUCCESSFULLY CREATED!!");
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
            if (in != null && in != null) {
                try {
                    in.close();
                    in2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void setTemplateMessage() {


        try {
            in = getClass().getClassLoader().getResourceAsStream("email.properties");
            if (in == null) {
                logger.error("File not found");
            }
            prop.load(in);
            templateMessage.setFrom(prop.getProperty("email.from"));
            logger.info(templateMessage.getFrom());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void setPerson() {


        in = getClass().getResourceAsStream("/person.properties");
        try {
            prop.load(in);
            person.setName(prop.getProperty("person.name"));
            person.setSurname(prop.getProperty("person.surname"));
            person.setCountry(prop.getProperty("person.country"));
            person.setNationality(prop.getProperty("person.nationality"));

        } catch (IOException e) {
            logger.error("ERROR!! File not found", e.getCause().toString());
            e.printStackTrace();
        } finally {
            try {
                in.close();
                logger.info("Person initialization completed successfully!!");
                logger.info(person.toString());
            } catch (IOException e) {
                logger.error("Error in initialization", e.getCause().toString());
                e.printStackTrace();
            }
        }

    }

    @Test
    public void ownerTestReadProp() {

        logger.info("Server: " + config.hostname() + "\n" + "port: " + config.port() + "\n" + "maxThreads: " + config.maxThreads());

    }

    @Test
    public void importPropFromClass() {

        Properties prop = new Properties();
        prop.setProperty("port", "80");
        prop.setProperty("hostname", "com.zaxxer");

        ImportConfig cfg = ConfigFactory.create(ImportConfig.class, prop);
        logger.info("Port is set to " + cfg.port());

    }

    @Test
    public void readXmlFile() {

        try {

            logger.info("Opening file prova.xml");
            File fXMLFile = new File("provaxml.xml");
            logger.info("FILE OPEN");
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(fXMLFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("gnc:transaction");
            logger.info("--------------------");

            for (int i = 0; i < nList.getLength(); i++) {

                Node node = nList.item(i);
                Element element = (Element) node;
                logger.info(element.getFirstChild().toString());
                logger.info("current element: " + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    logger.info("\n");
                    logger.info("Attribute name: " + element.getElementsByTagName("split:id").item(0).getTextContent());
                    logger.info("Attribute id: " + element.getElementsByTagName("split:value").item(0).getTextContent());
                    logger.info("Attribute type: " + element.getElementsByTagName("split:quantity").item(0).getTextContent());

                }

            }
        } catch (ParserConfigurationException e) {
            logger.error("ERROR: NO FILES TO PARSE");
            e.printStackTrace();
        } catch (SAXException e) {
            logger.error("ERROR: NO DOCUMENT TO BUILD");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("ERROR: READING XML FILE IS FAILED. READ STACKTRACE FOR MORE INFORMATIONS");
            e.printStackTrace();
        }

    }

}

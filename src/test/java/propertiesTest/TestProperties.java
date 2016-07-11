package propertiesTest;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by NICOLA on 11/07/2016.
 */
public class TestProperties {

    Properties prop = new Properties();
    OutputStream out = null;

    @Test
    public void writeProperties(){

        String comments = "This is only a test file!";

        try {
            OutputStream out = new FileOutputStream("config.properties");
            prop.setProperty("textcolor", "green");
            prop.setProperty("textfont","Arial");
            prop.store(out,comments);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if( out != null )
            {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

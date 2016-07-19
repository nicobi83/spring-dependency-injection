package propertiesTest;

import org.aeonbits.owner.Config;

/**
 * Created by NICOLA on 19/07/2016.
 */
public interface ImportConfig extends Config {

    @DefaultValue("0")
    int port();

    @DefaultValue("default_server")
    String hostname();

    @DefaultValue("1")
    int maxThreads();

}

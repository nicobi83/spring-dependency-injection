package propertiesTest;

import org.aeonbits.owner.Config;

/**
 * Created by NICOLA on 18/07/2016.
 */
@Config.LoadPolicy(Config.LoadType.MERGE)// Con questa annotazione permetto a Sources di sondare tutti i
//properties files che ci stanno all'interno delle graffe fino a quando vengono trovate le proprietà
@Config.Sources({"file:src\\test\\resources\\serverconfig.properties",
        "file:src\\test\\servertwoconfig.properties"})
public interface ServerConfig extends Config {

    @Key("port")
    @DefaultValue("80")
        //se non metto un valore intero come stringa in @DefaultValue allora viene lanciato un NullPointException
    int port();

    @Key("hostname")
    String hostname();

    @Key("maxThreads")
    @DefaultValue("42")
    int maxThreads();

    @Key("isDebugEnable")
    @DefaultValue("false")
        //se non metto un valore true o false come stringa in @DefaultValue allora viene lanciato un NullPointException
    Boolean debugEnabled();

}

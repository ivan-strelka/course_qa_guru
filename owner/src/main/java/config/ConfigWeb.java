package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${env}.properties")
public interface ConfigWeb extends Config {

    @Key("browser")
    String getBrowser();

    @Key("browser.version")
    String getBrowserVersion();

    @Key("selenoid.url")
    String getSelenoidUrl();
}

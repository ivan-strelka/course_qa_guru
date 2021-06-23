package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    private static ApiConfig getConfig() {
        return ConfigFactory.newInstance().create(ApiConfig.class, System.getProperties());
    }

    public static String getBaseURL() {
        return getConfig().baseURL();
    }

    public static String getEmail() {
        return getConfig().email();
    }

    public static String getPassword() {
        return getConfig().password();
    }


}

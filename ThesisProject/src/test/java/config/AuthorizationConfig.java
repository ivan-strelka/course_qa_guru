package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/authorization.properties"
})
public interface AuthorizationConfig extends Config {

    @Config.Key("sber.username")
    String sberUserName();

    @Config.Key("sber.password")
    String sberUserPassword();

}
package config;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:api.properties"

})
public interface ApiConfig extends Config {

    @Key("api.base.url")
    String baseURL();

    @Key("api.email")
    String email();

    @Key("api.password")
    String password();

}

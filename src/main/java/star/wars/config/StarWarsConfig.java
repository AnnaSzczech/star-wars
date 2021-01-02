package star.wars.config;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import star.wars.client.StarWarsClient;

@Configuration
public class StarWarsConfig {
    @Bean
    public StarWarsClient starWarsClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .logger(new Slf4jLogger(StarWarsClient.class))
                .logLevel(Logger.Level.FULL)
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(StarWarsClient.class, "https://swapi.dev/api");
    }
}

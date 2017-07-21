package game;
import game.controller.SecretContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Indhu on 5/1/2017.
 *
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public URIBuilder server() {
        return new URIBuilder("http://localhost:8080");
    }


    public static class URIBuilder {
        private final String serverURI;

        public URIBuilder(String serverURI) {
            this.serverURI = serverURI;
        }

        public String buildURI(String path){
            return serverURI + path;
        }
    }

    @Bean
    public SecretContainer container(){
        return new SecretContainer();
    }


}

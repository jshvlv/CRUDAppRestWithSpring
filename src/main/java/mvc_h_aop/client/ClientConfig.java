package mvc_h_aop.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("mvc_h_aop.client")
public class ClientConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

package alura.br.microservicesspringcloud.config;

import alura.br.microservicesspringcloud.networking.service.FornecedorServiceCore;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Client;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients
public class FeignConfig {

    @Value("${log.feign.level:BASIC}")
    private String logLevel;

    /** Setup a feign client. */
    @Autowired
    private Client client;

    @Autowired private ObjectMapper mapper;

    @Autowired FeignProperties feignProperties;

    /**
     * Setup a http client for feign configs.
     *
     * @return http client
     */
    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }

    @Bean
    FornecedorServiceCore fornecedorServiceCore(@Value("${srvc.core.entregador.url}") String url) {

        mapper.findAndRegisterModules();

        return Feign.builder()
                .encoder(new JacksonEncoder(mapper))
                .decoder(new JacksonDecoder(mapper))
                .retryer(Retryer.NEVER_RETRY)
                .client(client)
                .target(FornecedorServiceCore.class, url);
    }

}
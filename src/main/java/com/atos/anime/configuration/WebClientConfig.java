package com.atos.anime.configuration;

import com.atos.anime.models.APIResponse;
import io.netty.handler.logging.LogLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;


@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient(){
        HttpClient httpClient = HttpClient.create().wiretap("reactor.netty.http.client.HttpClient", LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);
       return WebClient.builder()
               .clientConnector(new ReactorClientHttpConnector(httpClient))
               .build();
    }

    public <T> Mono<T> get(String url , Map<String, String> headers,Class<T> tClazz) {
        return this.webClient().get()
                .uri(url)
                .headers(getHttpHeaders(headers))
                .retrieve()
                .bodyToMono(tClazz)
                .doOnNext(System.out::println);
    }

   private Consumer<HttpHeaders> getHttpHeaders(Map<String, String> headerMap) {
        return consumerHeaders -> {
            consumerHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            consumerHeaders.setContentType(MediaType.APPLICATION_JSON);
            if(null != headerMap){
                headerMap.keySet().forEach(key -> consumerHeaders.set(key, headerMap.get(key)));
            }
        };
   }
}

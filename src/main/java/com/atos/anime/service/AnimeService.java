package com.atos.anime.service;

import com.atos.anime.models.APIResponse;
import com.atos.anime.models.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
@Slf4j
@Service
public class AnimeService {
    @Autowired
    private WebClient webClient;


    public Mono<APIResponse> getAnimeImages(String category, int count){
        return webClient.get()
                .uri("/category")
                .retrieve()
                .bodyToMono(APIResponse.class);
    }

    public Mono<APIResponse> getTags(){
        return webClient.get()
                .uri("/tag")
                .retrieve()
                .bodyToMono(APIResponse.class);
    }
}

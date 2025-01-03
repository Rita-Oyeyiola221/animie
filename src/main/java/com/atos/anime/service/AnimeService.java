package com.atos.anime.service;

import com.atos.anime.configuration.NekosiaProperties;
import com.atos.anime.configuration.WebClientConfig;
import com.atos.anime.models.APIResponse;
import com.atos.anime.models.Data;
import com.atos.anime.models.Image;
import com.atos.anime.models.ImageAttributes;
import com.atos.anime.models.nekosia.NekosiaAPIResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class AnimeService {
    @Autowired
    WebClientConfig webClient;
    @Autowired
    NekosiaProperties nekosiaProperties;


    public Mono<? extends APIResponse> getAnimeImages(String category, Integer count){
        var uri = UriComponentsBuilder.fromUriString(String.format("%s/%s", nekosiaProperties.getBaseUrl(), nekosiaProperties.getCategoryUrl())).path(category)
                .build().toUriString();
        System.out.println(uri);
        //log.info("Getting anime images from {}", uri);
        //log.info("T");
        return webClient
                .get(uri, null,NekosiaAPIResponse.class)
                .flatMap(response -> {
                    var apiResponse = new Data();
                    apiResponse.setStatusCode((response).getStatus());
                    var image = new Image();
                    var originalImageAttributes = new ImageAttributes();
                    originalImageAttributes.setUrl(response.getImage().getOriginal().getUrl());
                    originalImageAttributes.setExtension(response.getImage().getOriginal().getExtension());
                    image.setOriginal(originalImageAttributes);
                    var compressedImageAttributes = new ImageAttributes();
                    compressedImageAttributes.setUrl(response.getImage().getCompressed().getUrl());
                    compressedImageAttributes.setExtension(response.getImage().getCompressed().getExtension());
                    image.setCompressed(compressedImageAttributes);
                    apiResponse.setImage(image);
                    apiResponse.setStatusMessage("message");
                    return Mono.just(apiResponse);
                });
    }

    public Mono<APIResponse> getTags(String url){
        return Mono.just(null);
    }

}


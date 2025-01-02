package com.atos.anime.controller;

import com.atos.anime.models.APIResponse;
import com.atos.anime.models.Data;
import com.atos.anime.service.AnimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
@RequestMapping ("/anime")
@RestController
@Slf4j
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @GetMapping ("/{category}")
    public Mono<? extends APIResponse> getAnimeImages(@PathVariable String category,
                                                  @RequestParam (defaultValue = "1") Integer count) {
        return animeService.getAnimeImages(category, count);
    }

    @GetMapping ("/tags")
    public Mono<APIResponse> getTags() {
       return animeService.getTags(null);
    }
}

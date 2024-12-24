package com.atos.anime.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
    private ImageAttributes original;
    private ImageAttributes compressed;
}

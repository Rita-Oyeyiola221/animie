package com.atos.anime.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
    private ImageAttributes original;
    private ImageAttributes compressed;

    public ImageAttributes getOriginal() {
        return original;
    }

    public void setOriginal(ImageAttributes original) {
        this.original = original;
    }

    public ImageAttributes getCompressed() {
        return compressed;
    }

    public void setCompressed(ImageAttributes compressed) {
        this.compressed = compressed;
    }
}

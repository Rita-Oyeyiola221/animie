package com.atos.anime.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageAttributes {
    private String url;
    private String extension;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}

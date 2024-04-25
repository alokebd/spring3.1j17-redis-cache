package com.vision.cache.payload;

import lombok.Data;

@Data
public class ProductResponse {
    private long id;
    private String title;
    private String description;

    public ProductResponse() {
    }
}

package com.vision.cache.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;

@Entity
@Table(name = "product_redis")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 2L;

    private String title;
    private String description;
}

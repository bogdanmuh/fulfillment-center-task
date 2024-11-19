package com.demo.task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "products")
@Getter
@Setter
public class Product
{

    @Id
    private UUID id;
    private String productId;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    private String fulfillmentCenter;
    private int Qty;
    private int value;

}
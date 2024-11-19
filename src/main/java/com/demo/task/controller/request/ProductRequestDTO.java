package com.demo.task.controller.request;

import com.demo.task.model.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class ProductRequestDTO
{

    private String productId;
    private ProductStatus status;
    private String fulfillmentCenter;
    private int qty;
    private int value;

}
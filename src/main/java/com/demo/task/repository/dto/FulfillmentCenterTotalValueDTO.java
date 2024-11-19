package com.demo.task.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class FulfillmentCenterTotalValueDTO
{

    private String fulfillmentCenter;
    private Long totalValue;

}

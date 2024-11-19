package com.demo.task.controller.swagger;

import com.demo.task.controller.request.ProductRequestDTO;
import com.demo.task.model.Product;
import com.demo.task.repository.dto.FulfillmentCenterTotalValueDTO;
import com.demo.task.repository.dto.SumDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;


@Tag(name = "Product Management", description = "Operations for managing products in fulfillment centers")
public interface ProductControllerSwagger
{

    @Operation(description = "Get all products by status")
    List<Product> getAllProducts();

    @Operation(description = "Add a new product")
    void createProduct(@RequestBody ProductRequestDTO productRequestDTO);

    @Operation(description = "Update an existing product")
    void updateProduct(@PathVariable UUID id,
            @RequestBody ProductRequestDTO productRequestDTO);

    @Operation(description = "Delete a product")
    void deleteProduct(@PathVariable UUID id);

    @Operation(description = "Get a product")
    Product getProductById(@PathVariable UUID id);

    @Operation(description = "Get products by status")
    List<Product> getProductsByStatus(@PathVariable String status);

    @Operation(description = "Get total value of all sellable products")
    SumDto getSumBySellable();

    @Operation(description = "Get total value of group FulfillmentCenter")
    List<FulfillmentCenterTotalValueDTO> getSumByFulfillmentCenter();

}

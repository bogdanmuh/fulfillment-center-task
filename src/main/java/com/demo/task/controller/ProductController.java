package com.demo.task.controller;

import com.demo.task.controller.request.ProductRequestDTO;
import com.demo.task.controller.swagger.ProductControllerSwagger;
import com.demo.task.model.Product;
import com.demo.task.model.ProductStatus;
import com.demo.task.repository.dto.FulfillmentCenterTotalValueDTO;
import com.demo.task.repository.dto.SumDto;
import com.demo.task.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController implements ProductControllerSwagger
{

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable UUID id)
    {
        return productService.getProductById(id);
    }

    @PostMapping
    public void createProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {
        productService.createProduct(productRequestDTO);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable UUID id,
            @RequestBody ProductRequestDTO productRequestDTO)
    {
        productService.updateProduct(id, productRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id)
    {
        productService.deleteProduct(id);
    }

    @GetMapping("/status/{status}")
    public List<Product> getProductsByStatus(@PathVariable String status)
    {
        return productService.getProductsByStatus(ProductStatus.valueOf(status.toUpperCase()));
    }

    @GetMapping("/sellable/sum")
    public SumDto getSumBySellable()
    {
        return productService.getSumBySellable();
    }

    @GetMapping("/groupby")
    public List<FulfillmentCenterTotalValueDTO> getSumByFulfillmentCenter()
    {
        return productService.getTotalValueByFulfillmentCenter();
    }

}
package com.demo.task.service;

import com.demo.task.controller.request.ProductRequestDTO;
import com.demo.task.model.Product;
import com.demo.task.model.ProductStatus;
import com.demo.task.repository.ProductRepository;
import com.demo.task.repository.dto.FulfillmentCenterTotalValueDTO;
import com.demo.task.repository.dto.SumDto;
import com.demo.task.service.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class ProductService
{

    private final ProductRepository productRepository;

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public Product getProductById(UUID id)
    {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }

    public Product createProduct(ProductRequestDTO productRequestDTO)
    {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setProductId(productRequestDTO.getProductId());
        product.setStatus(productRequestDTO.getStatus());
        product.setFulfillmentCenter(productRequestDTO.getFulfillmentCenter());
        product.setQty(productRequestDTO.getQty());
        product.setValue(productRequestDTO.getValue());

        return productRepository.save(product);
    }

    public Product updateProduct(UUID id, ProductRequestDTO productRequestDTO)
    {
        Product product = getProductById(id);

        product.setProductId(productRequestDTO.getProductId());
        product.setStatus(productRequestDTO.getStatus());
        product.setFulfillmentCenter(productRequestDTO.getFulfillmentCenter());
        product.setQty(productRequestDTO.getQty());
        product.setValue(productRequestDTO.getValue());

        return productRepository.save(product);
    }

    public void deleteProduct(UUID id)
    {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    public List<Product> getProductsByStatus(ProductStatus status)
    {
        return productRepository.findByStatus(status);
    }

    public SumDto getSumBySellable()
    {
        return new SumDto(getProductsByStatus(ProductStatus.SELLABLE).stream()
                .mapToInt(i -> i.getValue() * i.getQty())
                .sum());


    }

    public List<FulfillmentCenterTotalValueDTO> getTotalValueByFulfillmentCenter()
    {
        return productRepository.getTotalValueByFulfillmentCenter();
    }

}
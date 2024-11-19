package com.demo.task.repository;


import com.demo.task.model.Product;
import com.demo.task.model.ProductStatus;
import com.demo.task.repository.dto.FulfillmentCenterTotalValueDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>
{

    List<Product> findByStatus(ProductStatus status);

    @Query("SELECT new com.demo.task.repository.dto." +
            "FulfillmentCenterTotalValueDTO(p.fulfillmentCenter, SUM(p.Qty * p.value)) " +
            "FROM Product p " +
            "GROUP BY p.fulfillmentCenter")
    List<FulfillmentCenterTotalValueDTO> getTotalValueByFulfillmentCenter();

}
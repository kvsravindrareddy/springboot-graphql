package com.veera.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veera.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Long>{

}

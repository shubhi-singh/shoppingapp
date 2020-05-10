package com.shoppingapp.shoppingapp.dao;

import com.shoppingapp.shoppingapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

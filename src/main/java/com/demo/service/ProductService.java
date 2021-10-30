package com.demo.service;

import com.demo.entity.Products;
import com.demo.repo.OrderRepository;
import com.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    public List<Products> getAllProducts() {
      List<Products> productList =  productRepository.findAll();
      return productList;
    }


    public Float getSumOfOrderValueAllProducts(Integer pid) {
       Optional<Products> p =  productRepository.findById(pid);

    float val=  p.get().getOrders().stream().mapToInt(p1-> (int) p1.getOrdervalue()).sum();
       return val;
    }
}

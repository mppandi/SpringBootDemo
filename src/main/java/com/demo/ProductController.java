package com.demo;

import com.demo.entity.Products;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Products> getAllProducts() {
      return  new ResponseEntity(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{pid}")
    public String  getSumOfOrderValueAllProducts(@PathVariable Integer pid) {
        return "Total Order Value of Given Product Id: "+pid+" :: is :: "+ productService.getSumOfOrderValueAllProducts(pid);
    }


}

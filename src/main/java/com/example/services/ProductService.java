package com.example.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.entities.Product;
import com.example.models.entities.repos.ProductRepo;

@Service
@Transactional
public class ProductService{

    @Autowired
    private ProductRepo productRepo;

    public Product save (Product product){
        return productRepo.save(product);
    }

    public Product findOne(Long id){
        Optional<Product> Product = productRepo.findById(id);
        if(!Product.isPresent()){
            return null;
        }
        return Product.get();
    }
    public Iterable<Product> findAll(){

        return productRepo.findAll();
    }

    public void removeOne(long id){
        productRepo.deleteById(id);
    }
    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }
    }

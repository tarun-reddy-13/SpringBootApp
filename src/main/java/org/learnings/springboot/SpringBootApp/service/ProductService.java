package org.learnings.springboot.SpringBootApp.service;

import org.learnings.springboot.SpringBootApp.entity.Product;
import org.learnings.springboot.SpringBootApp.exception.ProductNotFoundException;
import org.learnings.springboot.SpringBootApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> productList){
        return repository.saveAll(productList);
    }

    public Product getProductById(int id){
//        Optional<Product> product = repository.findById(id);
//        return product.orElse(null);
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
       return repository.findByName(name);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }
    
    public Product updateProduct(int id, Product product){
        Product existingProduct = repository.findById(id).orElse(null);
        if(existingProduct==null)
            throw new ProductNotFoundException("Product Not Found");
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }

    public Product patchProduct(int id, Product product){
        Product existingProduct = repository.findById(id).orElse(null);
        if(existingProduct==null)
            throw new RuntimeException("Product Not Found");
        if(product.getName()!=null)
            existingProduct.setName(product.getName());
        if(product.getPrice()!=0)
            existingProduct.setPrice(product.getPrice());
        if(product.getQuantity()!=0)
            existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product deleted!!!";
    }
}

package org.learnings.springboot.SpringBootApp.controller;

import org.learnings.springboot.SpringBootApp.entity.Product;
import org.learnings.springboot.SpringBootApp.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productcatalog")
public class ProductController {
    Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        log.info("INFO:     Adding product with id {}", product.getId());
        System.out.println(product);
        return service.saveProduct(product);
    }

    @PostMapping("/addproducts")
    public List<Product> addProducts(@RequestBody List<Product> productList){
        return service.saveProducts(productList);
    }

    @GetMapping("/product-id/{id}")
    public Product findProductById(@PathVariable int id){
        log.info("INFO:     Finding product with id {}", id);
        return service.getProductById(id);
    }

    @GetMapping("/product-name/{name}")
    public ResponseEntity<Product> findProductById(@PathVariable String name){
        log.info("INFO:     Finding product with name {}", name);
        Product prod = service.getProductByName(name);
        return ResponseEntity.ok(prod);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/products")
    public List<Product> findAllProducts(@RequestHeader Map<String, String> header){
        log.info("INFO:     Retrieving all products");
        System.out.println(header);
        return service.getProducts();
    }

    @PutMapping("/product/update/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product){
        log.info("INFO:     Updating product with id {}", id);
        return service.updateProduct(id, product);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PatchMapping("/product/update/{id}")
    public Product patchProduct(@PathVariable int id, @RequestBody Product product){
        log.info("INFO:     Updating product with id {}", id);
        return service.patchProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        log.info("INFO:     Deleting product with id {}", id);
        return service.deleteProduct(id);
    }
}

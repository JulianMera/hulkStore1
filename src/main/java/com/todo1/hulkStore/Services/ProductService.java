package com.todo1.hulkStore.Services;

import com.todo1.hulkStore.Entities.Product;
import com.todo1.hulkStore.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(Product product){
        this.productRepository.save(product);
    }
    public List<Product> getAllProducts() {
        return (List<Product>) this.productRepository.findAll();
    }
    public Optional<Product> getProductById(String id) {
        return this.productRepository.findById(id);
    }
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }


}

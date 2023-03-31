package com.todo1.hulkStore.Controllers;

import com.todo1.hulkStore.Entities.Product;
import com.todo1.hulkStore.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private final ProductService productService;
    private final String mesagge = "Producto no Encontrado en Stock";
    private final String mesaggeError = "Campos no compatibles con la Peticion";

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{productId}")
    public ResponseEntity<Object> getProductById(@PathVariable("productId") String productId) {
        Optional<Product> optionalProduct = productService.getProductById(productId);
        if (optionalProduct.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND, HttpStatus.valueOf(mesagge));
    }
        return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllProducts(){
        return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<Object> createProduct(@RequestBody Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.productService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{producId}")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        this.productService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

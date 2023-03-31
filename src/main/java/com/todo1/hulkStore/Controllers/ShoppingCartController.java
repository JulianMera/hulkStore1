package com.todo1.hulkStore.Controllers;

import com.todo1.hulkStore.Entities.ShoppingCart;
import com.todo1.hulkStore.Services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/{clientName}")
    public ResponseEntity<List<ShoppingCart>> getListByClient(@PathVariable("clientName") String clientName) {
        return new ResponseEntity<>(this.shoppingCartService.findByClientName(clientName), HttpStatus.OK);
    }

    @GetMapping("/count/{clientId}")
    public ResponseEntity<Long> countByClient (@PathVariable("clientId") String clientId) {
        return new ResponseEntity<>(this.shoppingCartService.countByClientId(clientId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<Object> addProduct(@RequestBody ShoppingCart shoppingCart) {
        this.shoppingCartService.addProduct(shoppingCart);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("clean/{itemId}")
    public ResponseEntity<Object> removeProduct(@PathVariable("itemId") String itemId) {
        this.shoppingCartService.cleanShoppingCart(itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

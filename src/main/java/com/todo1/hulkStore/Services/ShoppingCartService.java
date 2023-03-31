package com.todo1.hulkStore.Services;

import com.todo1.hulkStore.Entities.Product;
import com.todo1.hulkStore.Entities.ShoppingCart;
import com.todo1.hulkStore.Repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<ShoppingCart> findByClientName(String clientName){
        return this.shoppingCartRepository.findByClientName(clientName);
    }
    public void cleanShoppingCart(String clientId) {
        this.shoppingCartRepository.deleteByClientId(clientId);
    }
    public void removeProducts(String Id) {
        this.shoppingCartRepository.deleteById(Id);
    }
    public void addProduct(ShoppingCart shoppingCart) {
        this.shoppingCartRepository.save(shoppingCart);
    }
    public Long countByClientId(String clientId) {
        return this.shoppingCartRepository.countByClientId(clientId);
    }
}

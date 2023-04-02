package com.todo1.hulkStore.Repositories;


import com.todo1.hulkStore.Entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String> {
    List<ShoppingCart> findByClientId(String clientId);
    List<ShoppingCart> findByClientUser(String clientName);
    void deleteByClientId(String clientId);
    Long countByClientId(String clientId);
}

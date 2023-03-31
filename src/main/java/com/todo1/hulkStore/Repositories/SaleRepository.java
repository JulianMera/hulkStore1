package com.todo1.hulkStore.Repositories;

import com.todo1.hulkStore.Entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, String> {
    List<Sale> findByClient (String clientName);
}

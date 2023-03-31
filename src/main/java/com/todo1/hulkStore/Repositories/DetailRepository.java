package com.todo1.hulkStore.Repositories;

import com.todo1.hulkStore.Entities.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, String> {
    List<Detail> findBySaleId(String saleID);
}

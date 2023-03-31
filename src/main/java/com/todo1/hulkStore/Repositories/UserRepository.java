package com.todo1.hulkStore.Repositories;

import com.todo1.hulkStore.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByUserName(String userName);
}

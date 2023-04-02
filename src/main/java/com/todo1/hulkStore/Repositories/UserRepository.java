package com.todo1.hulkStore.Repositories;

import com.todo1.hulkStore.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //@Query(value = "select u.id, u.user, u.password from user u where u.user = :userName", nativeQuery = true)
    List<User> findByUser(@Param("userName") String userName);
}

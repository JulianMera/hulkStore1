package com.todo1.hulkStore.Services;

import com.todo1.hulkStore.Entities.User;
import com.todo1.hulkStore.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getClientByUserName(String userName) {
        return this.userRepository.findByUser(userName);
    }
}

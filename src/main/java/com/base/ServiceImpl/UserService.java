package com.base.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.base.models.User;
import com.base.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User createUser(User user) {
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUser(Long id) {
        return repo.findById(id).orElse(null);
    }
}
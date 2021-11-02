package com.suhmoraes.projectmongodbandspringboot.services;

import com.suhmoraes.projectmongodbandspringboot.entities.User;
import com.suhmoraes.projectmongodbandspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}

package com.suhmoraes.projectmongodbandspringboot.config;

import com.suhmoraes.projectmongodbandspringboot.entities.User;
import com.suhmoraes.projectmongodbandspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User fernanda = new User(null, "martinez@ermail.com", "Fernanda Martinez");
        User alex = new User(null, "alex_nascimento@ermail.com", "Alex Nascimento");
        User ruy  = new User(null, "rui@ermail.com", "Ruy Barbosa");

        userRepository.saveAll(Arrays.asList(fernanda, alex, ruy));
    }
}

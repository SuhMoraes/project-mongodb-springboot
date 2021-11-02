package com.suhmoraes.projectmongodbandspringboot.controllers;

import com.suhmoraes.projectmongodbandspringboot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

        @GetMapping
        public ResponseEntity<List<User>> findAll() {
            User user1 = new User("1", "maria@ermail.com", "Maria Calvacantti");
            User user2 = new User ("2", "joao@ermail.com", "João Augusto");
            List<User> list = new ArrayList<>(); //Criando uma nova lista de usuário
            list.addAll(Arrays.asList(user1, user2)); // Adicionando usuários na lista
            return ResponseEntity.ok().body(list); // Responde a requisição com OK e no corpo(.body()) será a resposta

        }

}

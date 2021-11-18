package com.suhmoraes.projectmongodbandspringboot.dto;

import com.suhmoraes.projectmongodbandspringboot.model.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    private String id;

    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User user) {  // Recebe o User como argumento
        id = user.getId(); // Instanciando o id apartir do user
        name = user.getName(); // Instanciando o name apartir do user
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

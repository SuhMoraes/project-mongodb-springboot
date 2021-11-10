package com.suhmoraes.projectmongodbandspringboot.dto;

import com.suhmoraes.projectmongodbandspringboot.entities.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String id;

    private String name;

    private String email;

    public UserDTO() {
    }

    public UserDTO(User user) { // Consctrutor para instacianr a partir do obj entity
       id = user.getId();
       name = user.getName();
       email = user.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

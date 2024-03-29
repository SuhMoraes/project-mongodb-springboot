package com.suhmoraes.projectmongodbandspringboot.services;

import com.suhmoraes.projectmongodbandspringboot.dto.UserDTO;
import com.suhmoraes.projectmongodbandspringboot.model.User;
import com.suhmoraes.projectmongodbandspringboot.exception.ObjectNotFoundException;
import com.suhmoraes.projectmongodbandspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repo.findById(id); // Busca o user pelo id
        // Caso o usuário não seja encontrado...
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); // lança uma exception
    }

    public User insert(User user ){
        return repo.insert(user);
    }

    public void deleteById(String id) {
        if(!(findById(id) == null)) {
            repo.deleteById(id);
        }
    }

    public User update(User user) {
        User newUser = repo.findById(user.getId()).get();
        updateData(newUser, user); // -> Responsável por copiar os dados
        return repo.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(),
                userDTO.getEmail(),
                userDTO.getName());
    }

}



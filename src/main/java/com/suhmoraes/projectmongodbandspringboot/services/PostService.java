package com.suhmoraes.projectmongodbandspringboot.services;

import com.suhmoraes.projectmongodbandspringboot.entities.Post;
import com.suhmoraes.projectmongodbandspringboot.exception.ObjectNotFoundException;
import com.suhmoraes.projectmongodbandspringboot.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> post = repo.findById(id); // Busca o user pelo id
        // Caso o usuário não seja encontrado...
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));

    }


}



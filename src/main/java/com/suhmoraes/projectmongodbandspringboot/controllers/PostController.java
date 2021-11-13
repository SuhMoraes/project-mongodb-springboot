package com.suhmoraes.projectmongodbandspringboot.controllers;

import com.suhmoraes.projectmongodbandspringboot.controllers.util.URL;
import com.suhmoraes.projectmongodbandspringboot.entities.Post;
import com.suhmoraes.projectmongodbandspringboot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findByIdPost(@PathVariable String id) {
       Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    // Fazer a busca
    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
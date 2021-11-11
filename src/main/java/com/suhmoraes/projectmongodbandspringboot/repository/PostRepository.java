package com.suhmoraes.projectmongodbandspringboot.repository;

import com.suhmoraes.projectmongodbandspringboot.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {


}

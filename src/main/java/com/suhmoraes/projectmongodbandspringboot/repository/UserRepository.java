package com.suhmoraes.projectmongodbandspringboot.repository;

import com.suhmoraes.projectmongodbandspringboot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {


}

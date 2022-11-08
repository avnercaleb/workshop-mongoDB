package com.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workshopmongo.entities.User;

@Repository
public interface UserRepositoy extends MongoRepository<User, String>{

}

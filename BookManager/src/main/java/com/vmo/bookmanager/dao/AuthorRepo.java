package com.vmo.bookmanager.dao;

import com.vmo.bookmanager.entities.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepo extends MongoRepository<Author, String> {

}

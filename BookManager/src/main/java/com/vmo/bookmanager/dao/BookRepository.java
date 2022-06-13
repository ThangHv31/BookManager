package com.vmo.bookmanager.dao;

import com.vmo.bookmanager.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

}

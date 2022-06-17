package com.vmo.bookmanager.dao;

import com.vmo.bookmanager.dto.BookDTO;
import com.vmo.bookmanager.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<BookDTO> findBookByAuthorName(String authorName);
}

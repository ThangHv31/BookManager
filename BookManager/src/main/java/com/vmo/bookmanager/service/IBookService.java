package com.vmo.bookmanager.service;

import com.vmo.bookmanager.dto.BookDTO;
import com.vmo.bookmanager.entities.Book;

public interface IBookService {

    Book toEntity(BookDTO bookDTO) ;

    public BookDTO toDTO(Book book) ;


}

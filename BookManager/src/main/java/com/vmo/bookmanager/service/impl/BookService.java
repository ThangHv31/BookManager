package com.vmo.bookmanager.service.impl;

import com.vmo.bookmanager.dao.BookRepository;
import com.vmo.bookmanager.dto.BookDTO;
import com.vmo.bookmanager.entities.Book;
import com.vmo.bookmanager.mapper.BookMapper;
import com.vmo.bookmanager.mapper.BookMapperImpl;
import com.vmo.bookmanager.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepo;
    private final AuthorService authorService;
    private final BookMapper bookMapper = new BookMapperImpl();

    public BookService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public BookDTO create(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        bookRepo.save(book);
        return bookDTO;
    }

    @Override
    public BookDTO update(String id, BookDTO bookDTO) {
        Book oldBook = bookRepo.findById(id).get();
        oldBook = bookMapper.toEntity(bookDTO);
        bookRepo.save(oldBook);
        return bookDTO;
    }

    @Override
    public BookDTO findById(String id) {
        Book book = bookRepo.findById(id).get();
        return bookMapper.toDTO(book);
    }

    @Override
    public List<BookDTO> findAll() {
        return bookMapper.toDTOList(bookRepo.findAll());
    }
    public List<BookDTO> findByAuthor(String name){
        List<BookDTO> bookList = bookRepo.findBookByAuthorName(name);
        return bookList;
    }
    @Override
    public void delete(String id) {
        bookRepo.delete(bookRepo.findById(id).get());
    }

}

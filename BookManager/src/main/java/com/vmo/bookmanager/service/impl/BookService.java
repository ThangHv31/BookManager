package com.vmo.bookmanager.service.impl;

import com.vmo.bookmanager.dao.BookRepository;
import com.vmo.bookmanager.dto.BookDTO;
import com.vmo.bookmanager.entities.Book;
import com.vmo.bookmanager.exception.ManagementException;
import com.vmo.bookmanager.mapper.BookMapper;
import com.vmo.bookmanager.mapper.BookMapperImpl;
import com.vmo.bookmanager.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepo;
    private final AuthorService authorService;
    private final BookMapper bookMapper = new BookMapperImpl();

    @Override
    public BookDTO create(BookDTO bookDTO) {
        validateBook(bookDTO);
        Book book = bookMapper.toEntity(bookDTO);
        bookRepo.save(book);
        return bookDTO;
    }
    private boolean validateBook(BookDTO bookDTO){
        if(Strings.isEmpty(bookDTO.getContent())){
            throw  new ManagementException();
        }
        return true;
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
    public String delete(String id) {
        Book book = bookRepo.findById(id).get();
        if(book != null){
            bookRepo.delete(book);
            return "Deleted!";
        }
        return "Book not found";
    }

    public BookService(BookRepository bookRepo, AuthorService authorService) {
        this.bookRepo = bookRepo;
        this.authorService = authorService;
    }


}

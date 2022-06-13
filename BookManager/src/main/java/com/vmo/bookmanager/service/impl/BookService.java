package com.vmo.bookmanager.service.impl;

import com.vmo.bookmanager.dao.AuthorRepo;
import com.vmo.bookmanager.dao.BookRepository;
import com.vmo.bookmanager.dto.BookDTO;
import com.vmo.bookmanager.entities.Book;
import com.vmo.bookmanager.service.IBaseService;
import com.vmo.bookmanager.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements IBaseService<BookDTO>, IBookService {
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private AuthorRepo authorRepo;

//    private final BookRepository bookRepo;
//
//    public BookService(BookRepository bookRepo) {
//        this.bookRepo = bookRepo;
//    }

    @Override
    public BookDTO create(BookDTO bookDTO) {
        bookRepo.save(toEntity(bookDTO));
        return bookDTO;
    }

    public BookDTO update(String id, BookDTO bookDTO) {
        Book oldBook = bookRepo.findById(id).get();
        oldBook.setBookName(bookDTO.getBookName());
        oldBook.setContent(bookDTO.getContent());
        oldBook.setAuthorName(bookDTO.getAuthorName());
        oldBook.setDescription(bookDTO.getDescription());
        oldBook.setTitle(bookDTO.getTitle());
        bookRepo.save(oldBook);
        return bookDTO;
    }

    @Override
    public BookDTO findById(String id) {
        Book book = bookRepo.findById(id).get();
        return toDTO(book);
    }

    @Override
    public List<BookDTO> findAll() {
        List<Book> list = bookRepo.findAll();
        List<BookDTO> listRespone = new ArrayList<>();
        for (Book book : list) {
            listRespone.add(toDTO(book));
        }
        return listRespone;
    }

    @Override
    public void delete(String id) {
        bookRepo.delete(bookRepo.findById(id).get());
    }

    @Override
    public Book toEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setAuthorName(bookDTO.getAuthorName());
        book.setBookName(bookDTO.getBookName());
        book.setContent(bookDTO.getContent());
        book.setDescription(bookDTO.getDescription());
        book.setTitle(bookDTO.getTitle());
        return book;
    }

    @Override
    public BookDTO toDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthorName(book.getAuthorName());
        bookDTO.setBookName(book.getBookName());
        bookDTO.setContent(book.getContent());
        bookDTO.setDescription(book.getDescription());
        bookDTO.setTitle(book.getTitle());
        return bookDTO;
    }
}

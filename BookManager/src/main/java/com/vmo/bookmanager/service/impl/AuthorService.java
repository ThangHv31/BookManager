package com.vmo.bookmanager.service.impl;

import com.vmo.bookmanager.dao.AuthorRepo;
import com.vmo.bookmanager.dao.BookRepository;
import com.vmo.bookmanager.dto.AuthorDTO;
import com.vmo.bookmanager.entities.Author;
import com.vmo.bookmanager.entities.Book;
import com.vmo.bookmanager.mapper.AuthorMapper;
import com.vmo.bookmanager.mapper.AuthorMapperImpl;
import com.vmo.bookmanager.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private BookRepository bookRepo;
    private final AuthorMapper authorMapper = new AuthorMapperImpl();
    @Override
    public AuthorDTO create(AuthorDTO authorDTO) {
        Author author = authorMapper.toEntity(authorDTO);
        for (Book book: author.getBookList()){
            bookRepo.save(book);
        }
        authorRepo.save(author);
        return authorDTO;
    }
    @Override
    public AuthorDTO update(String id, AuthorDTO authorDTO) {
        Author author = authorRepo.findById(id).get();
        author = authorMapper.toEntity(authorDTO);
        authorRepo.save(author);
        return authorMapper.toDTO(author);
    }

    @Override
    public AuthorDTO findById(String id) {
        Author author = authorRepo.findById(id).get();
        return authorMapper.toDTO(author);
    }

    @Override
    public List<AuthorDTO> findAll() {
        return authorMapper.toDTOList(authorRepo.findAll());
    }

    @Override
    public void delete(String id) {
        authorRepo.delete(authorRepo.findById(id).get());
    }
}

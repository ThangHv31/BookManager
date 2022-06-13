package com.vmo.bookmanager.service.impl;

import com.vmo.bookmanager.dao.AuthorRepo;
import com.vmo.bookmanager.dto.AuthorDTO;
import com.vmo.bookmanager.entities.Author;
import com.vmo.bookmanager.service.IAuthorService;
import com.vmo.bookmanager.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService implements IAuthorService, IBaseService<AuthorDTO> {
    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public Author toEntity(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setAuthorName(authorDTO.getAuthorName());
        author.setBirthDate(authorDTO.getBirthDate());
        author.setEmail(authorDTO.getEmail());
        author.setPhoneName(authorDTO.getPhoneName());
        author.setBookList(authorDTO.getBookList());
        return author;
    }

    @Override
    public AuthorDTO toDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setAuthorName(author.getAuthorName());
        authorDTO.setBirthDate(author.getBirthDate());
        authorDTO.setEmail(author.getEmail());
        authorDTO.setPhoneName(author.getPhoneName());
        authorDTO.setBookList(author.getBookList());
        return authorDTO;
    }

    @Override
    public AuthorDTO create(AuthorDTO authorDTO) {
        authorRepo.save(toEntity(authorDTO));
        return authorDTO;
    }

    public AuthorDTO update(String id, AuthorDTO authorDTO) {
        Author author = authorRepo.findById(id).get();
        author.setAuthorName(authorDTO.getAuthorName());
        author.setEmail(authorDTO.getEmail());
        author.setBirthDate(authorDTO.getBirthDate());
        author.setPhoneName(authorDTO.getPhoneName());
        authorRepo.save(author);
        return authorDTO;
    }

    @Override
    public AuthorDTO findById(String id) {
        Author author = authorRepo.findById(id).get();
        return toDTO(author);
    }

    @Override
    public List<AuthorDTO> findAll() {
        List<Author> list = authorRepo.findAll();
        List<AuthorDTO> listRespone = new ArrayList<>();
        for (Author author : list) {
            listRespone.add(toDTO(author));
        }
        return listRespone;
    }

    @Override
    public void delete(String id) {
        authorRepo.delete(authorRepo.findById(id).get());
    }
}

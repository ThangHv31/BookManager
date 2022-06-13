package com.vmo.bookmanager.service;

import com.vmo.bookmanager.dto.AuthorDTO;
import com.vmo.bookmanager.entities.Author;

public interface IAuthorService {
    Author toEntity(AuthorDTO authorDTO) ;

    public AuthorDTO toDTO(Author author) ;
}

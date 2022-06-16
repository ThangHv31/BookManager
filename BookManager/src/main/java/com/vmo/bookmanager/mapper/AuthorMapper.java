package com.vmo.bookmanager.mapper;

import com.vmo.bookmanager.dto.AuthorDTO;
import com.vmo.bookmanager.entities.Author;
import org.mapstruct.Mapper;


@Mapper
public interface AuthorMapper extends EntityMapper<AuthorDTO, Author> {

}

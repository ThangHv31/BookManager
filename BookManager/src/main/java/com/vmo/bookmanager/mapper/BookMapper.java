package com.vmo.bookmanager.mapper;

import com.vmo.bookmanager.dto.BookDTO;
import com.vmo.bookmanager.entities.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper extends EntityMapper<BookDTO, Book> {
//    @Override
//    @Mapping(source = "authorName", target = "author_name")
//    BookDTO toDTO(Book entity);
//
//    @Override
//    @Mapping(source = "authorName", target = "author_name")
//    List<BookDTO> toDTOList(List<Book> entityList);
}

package com.vmo.bookmanager;

import com.vmo.bookmanager.dao.BookRepository;
import com.vmo.bookmanager.mapper.BookMapperImpl;
import com.vmo.bookmanager.service.IBookService;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BookServicrTest {
    @Mock
    private BookRepository bookRepository;
    private BookMapperImpl bookMapper;
    private IBookService bookService;



}

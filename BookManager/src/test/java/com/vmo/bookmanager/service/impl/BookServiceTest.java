package com.vmo.bookmanager.service.impl;

import com.vmo.bookmanager.dao.BookRepository;
import com.vmo.bookmanager.dto.BookDTO;
import com.vmo.bookmanager.entities.Book;
import com.vmo.bookmanager.exception.ManagementException;
import com.vmo.bookmanager.mapper.BookMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    @Mock
    private BookMapper bookMapper;
    private MockMvc mockMvc;
    @InjectMocks
    private BookService bookService;
    Book book1 = new Book("Sach", "Sach", "Ruoi Trau", "sach nuoc ngoai", "Mario Puzzo");
    Book book2 = new Book("Book", "Book", "Ruoi Trau", "sach nuoc ngoai", "Mario Puzzo");

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookService).build();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {

    }

    @Test
    public void whenCreateBook_thenSuccess() {
        BookDTO bookDto = new BookDTO(
                "Sach",
                "Sach",
                "Ruoi Trau",
                "sach nuoc ngoai",
                "Mario Puzzo"
        );
        Book book = new Book(
                "Sach",
                "Sach",
                "Ruoi Trau",
                "sach nuoc ngoai",
                "Mario Puzzo"
        );
        when(bookMapper.toEntity(any(BookDTO.class))).thenReturn(book);
        when(bookRepository.save(any())).thenReturn(book);
        BookDTO bookDTO = bookService.create(bookDto);
        Assert.assertEquals(book.getTitle(), bookDTO.getTitle());
    }
    @Test(expected = NullPointerException.class)
    public void whenCreateBook_thenThrowEx() {

    }

    @Test
    void update() {
        String id = "1";
        BookDTO book = new BookDTO();
        book.setBookName("3");
        bookService.update(id, book);
    }


    @Test
    void findByIdTest() {
        String id = "62aae581c8db5308cf69cba5";
        Mockito.when(bookRepository.findById(id))
                .thenReturn(Optional.of((Book) Stream.of(new Book("Sach",
                        "Sach",
                        "Ruoi Trau",
                        "sach nuoc ngoai",
                        "Mario Puzzo")).collect(Collectors.toList())));
        Assert.assertEquals(1, bookService.findAll().size());

    }

    @Test
    void findAll() throws Exception {
        //when
        List<Book> list = new ArrayList<>(Arrays.asList(book1,book2));
        Mockito.when(bookRepository.findAll()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
    }

    @Test
    void delete() {
        bookService.delete("62aae581c8db5308cf69cba5");
        Mockito.verify(bookRepository).deleteById("62aae581c8db5308cf69cba5");
    }
}
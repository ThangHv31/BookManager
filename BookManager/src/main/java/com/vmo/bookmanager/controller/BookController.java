package com.vmo.bookmanager.controller;

import com.vmo.bookmanager.dto.BookDTO;
import com.vmo.bookmanager.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/api/v1")
public class BookController {
    @Autowired
    private BookService bookService;
    //Lay ra danh sach Book
    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getBook(){
        return ResponseEntity.ok().body(bookService.findAll());
    }
    //Lay san pham theo id
    @GetMapping("/books/{id}")
    public ResponseEntity<BookDTO> getById(@PathVariable("id")String id){
        return ResponseEntity.ok().body(bookService.findById(id));
    }
    //Them san pham
    @PostMapping(value = "/books")
    public ResponseEntity<BookDTO> createBook(@RequestBody @Valid BookDTO book) {
        return ResponseEntity.ok().body(bookService.create(book));
    }
    //update
    @PutMapping("/books/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable("id")String id,@Valid @RequestBody  BookDTO book){
        return ResponseEntity.ok().body(bookService.update(id,book));
    }
    //Xoa
    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")String id){
        bookService.delete(id);
        String title = "Delete Sucessfully!";
        return ResponseEntity.ok(title);
    }
}

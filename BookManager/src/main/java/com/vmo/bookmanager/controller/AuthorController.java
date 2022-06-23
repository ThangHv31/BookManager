package com.vmo.bookmanager.controller;


import com.vmo.bookmanager.dto.AuthorDTO;
import com.vmo.bookmanager.service.impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/api/v1")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    //Lay ra tat ca tac gia
    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDTO>> getAuthor() {
        return ResponseEntity.ok().body(authorService.findAll());
    }

    //Tim tac gia theo id
    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorDTO> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(authorService.findById(id));
    }

    //Them moi tac gia
    @PostMapping(value = "/authors")
    public ResponseEntity<AuthorDTO> createAuthor(@Valid @RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok().body(authorService.create(authorDTO));
    }

    //Update thong tin tac gia
    @PutMapping("/authors/{id}")
    public ResponseEntity<AuthorDTO> updateBook(@PathVariable("id") String id, @Valid @RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok().body(authorService.update(id, authorDTO));
    }

    //Xoa tac gia
    @DeleteMapping("/authors/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        authorService.delete(id);
        String title = "Delete Sucessfully!";
        return ResponseEntity.ok(title);
    }
}

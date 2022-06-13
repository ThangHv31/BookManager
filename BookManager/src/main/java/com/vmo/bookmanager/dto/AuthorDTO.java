package com.vmo.bookmanager.dto;

import com.vmo.bookmanager.entities.Book;

import java.util.List;

public class AuthorDTO {
    private String authorName;
    private String birthDate;
    private Double phoneName;
    private String email;
    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Double getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(Double phoneName) {
        this.phoneName = phoneName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AuthorDTO(String authorName, String birthDate, Double phoneName, String email) {
        this.authorName = authorName;
        this.birthDate = birthDate;
        this.phoneName = phoneName;
        this.email = email;
    }

    public AuthorDTO() {
    }
}

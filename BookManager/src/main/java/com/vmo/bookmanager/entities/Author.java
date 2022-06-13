package com.vmo.bookmanager.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;

@Document(collection = "author")
public class Author extends BaseEntity{
    @Id
    private String id;
    @Field(name = "author_name")
    private String authorName;
    @Field(name = "birth_date")
    private String birthDate;
    @Field(name = "phone_name")
    private Double phoneName;
    @Field(name = "email")
    private String email;
    @Field(name = "book_list")
    private List<Book> bookList;

    public Author() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}

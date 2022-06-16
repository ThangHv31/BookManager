package com.vmo.bookmanager.dto;


import org.mapstruct.Mapping;

import javax.validation.constraints.NotEmpty;

public class BookDTO {
    @NotEmpty(message = "Không được để trống")
    private String title;
    @NotEmpty(message = "Không được để trống")
    private String content;
    @NotEmpty(message = "Không được để trống")
    private String bookName;
    @NotEmpty(message = "Không được để trống")
    private String description;

    private String authorName;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}

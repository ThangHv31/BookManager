package com.vmo.bookmanager.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class AuthorDTO {
    @NotEmpty(message = "Không được để trống")
    private String authorName;
    @NotEmpty
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}")
    private String birthDate;
    @NotEmpty(message = "Không được để trống")
    private String phoneName;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,})$")
    private String email;
    private List<BookDTO> bookList;
    public List<BookDTO> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookDTO> bookList) {
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

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AuthorDTO(String authorName, String birthDate, String phoneName, String email, List<BookDTO> bookList) {
        this.authorName = authorName;
        this.birthDate = birthDate;
        this.phoneName = phoneName;
        this.email = email;
        this.bookList = bookList;
    }

    public AuthorDTO() {
    }
}

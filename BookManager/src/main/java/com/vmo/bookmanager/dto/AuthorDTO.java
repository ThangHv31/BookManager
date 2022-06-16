package com.vmo.bookmanager.dto;

import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class AuthorDTO {
    @NotEmpty(message = "Không được để trống")
    private String authorName;

    private String birthDate;
    @NotEmpty(message = "Không được để trống")
    @Min(value = 10, message = "Số điện thoại gồm 10 chữ số")
    @Max(value = 10, message = "Số điện thoại gồm 10 chữ số")
    private String phoneName;
    @NotEmpty
    @Email(message = "Email không đúng định dạng")
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

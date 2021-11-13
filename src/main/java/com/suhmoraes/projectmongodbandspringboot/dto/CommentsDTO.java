package com.suhmoraes.projectmongodbandspringboot.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentsDTO implements Serializable {

    private String text;

    private Date date;

    private AuthorDTO author;

    public CommentsDTO() {
    }

    public CommentsDTO(String text, Date date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}

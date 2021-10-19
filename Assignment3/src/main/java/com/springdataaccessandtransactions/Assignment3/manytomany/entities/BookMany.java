package com.springdataaccessandtransactions.Assignment3.manytomany.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bookmany")
public class BookMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "bookname")
    private String bookName;

    @ManyToMany(mappedBy = "books")
    private List<AuthorMany> authors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<AuthorMany> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorMany> authors) {
        this.authors = authors;
    }
}

package com.springdataaccessandtransactions.Assignment3.onetoone.entities;

import javax.persistence.*;

@Entity
@Table(name = "bookone")
public class BookOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "bookname")
    private String bookName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorid")
    private AuthorOne author;

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

    public AuthorOne getAuthor() {
        return author;
    }

    public void setAuthor(AuthorOne author) {
        this.author = author;
    }
}

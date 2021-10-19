package com.springdataaccessandtransactions.Assignment3.onetomany.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int authorId;
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private List<Subject> subjects;

    /******** Bidirectional One to Many Mapping ******/
    //@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    /****** Unidirectional One To Many mapping *****/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorid")
    private List<Book> books;

    @Embedded
    private Address address;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        if(book != null){
            if(books == null){
                books = new ArrayList<>();
            }
            book.setAuthor(this);
            books.add(book);
        }
    }

    public void addSubject(Subject subject){
        if(subject != null){
            if(subjects == null)
                subjects = new ArrayList<>();

            subject.setAuthor(this);
            subjects.add(subject);
        }
    }
}

package com.springdataaccessandtransactions.Assignment3.onetoonetests;

import com.springdataaccessandtransactions.Assignment3.onetoone.entities.AuthorOne;
import com.springdataaccessandtransactions.Assignment3.onetoone.entities.BookOne;
import com.springdataaccessandtransactions.Assignment3.onetoone.repos.BookOneRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class OneToOneTests {

    @Autowired
    BookOneRepository bookOneRepository;

    @Test
    public void testOneToOne(){
        BookOne bookOne = new BookOne();
        bookOne.setBookName("Java");

        AuthorOne author = new AuthorOne();
        author.setName("Vaishali");
        author.setBook(bookOne);

        bookOne.setAuthor(author);
        bookOneRepository.save(bookOne);
    }
}

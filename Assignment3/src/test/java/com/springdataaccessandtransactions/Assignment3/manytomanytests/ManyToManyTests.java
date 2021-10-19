package com.springdataaccessandtransactions.Assignment3.manytomanytests;

import com.mysql.cj.Session;
import com.springdataaccessandtransactions.Assignment3.manytomany.entities.AuthorMany;
import com.springdataaccessandtransactions.Assignment3.manytomany.entities.BookMany;
import com.springdataaccessandtransactions.Assignment3.manytomany.repos.AuthorManyRepository;
import com.springdataaccessandtransactions.Assignment3.onetomany.entities.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyTests {

    @Autowired
    AuthorManyRepository authorManyRepository;

    @Test
    public void TestManyToManyCreateData(){
        AuthorMany authorMany = new AuthorMany();
        authorMany.setName("Vaishali");

        List<BookMany> books = new ArrayList<>();
        BookMany book1 = new BookMany();
        book1.setBookName("Java");
        books.add(book1);

        authorMany.setBooks(books);
        authorManyRepository.save(authorMany);
    }




}

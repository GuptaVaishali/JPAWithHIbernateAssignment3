package com.springdataaccessandtransactions.Assignment3;

import com.springdataaccessandtransactions.Assignment3.onetomany.entities.Address;
import com.springdataaccessandtransactions.Assignment3.onetomany.entities.Author;
import com.springdataaccessandtransactions.Assignment3.onetomany.entities.Book;
import com.springdataaccessandtransactions.Assignment3.onetomany.entities.Subject;
import com.springdataaccessandtransactions.Assignment3.onetomany.repos.AuthorRepository;
import com.springdataaccessandtransactions.Assignment3.transactions.services.BankAccountService;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class Assignment3ApplicationTests {

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	EntityManager entityManager;

	@Autowired
	BankAccountService service;

	@Test
	void contextLoads() {
	}

	/********** Test for bidirectional one to many mapping **********/
	/*
	@Test
	public void testCreateAuthor(){
		Author author = new Author();
		author.setName("Vaishali");

		Address address = new Address();
		address.setLocation("Faridabad");
		address.setStreetnumber(131);
		address.setState("Haryana");

		author.setAddress(address);

		List<Subject> subjects = new ArrayList<>();
		Subject subject1 = new Subject();
		subject1.setSubName("Maths");
		subject1.setAuthor(author);
		subjects.add(subject1);

		Subject subject2 = new Subject();
		subject2.setSubName("English");
		subject2.setAuthor(author);
		subjects.add(subject2);

		Subject subject3 = new Subject();
		subject3.setSubName("Hindi");
		subject3.setAuthor(author);
		subjects.add(subject3);

		author.setSubjects(subjects);

		List<Book> books = new ArrayList<>();
		Book book1 = new Book();
		book1.setBookName("Java");
		book1.setAuthor(author);

		Book book2 = new Book();
		book2.setBookName("Cpp");
		book2.setAuthor(author);

		books.add(book1);
		books.add(book2);

		author.setBooks(books);

		authorRepository.save(author);
	}
	*/

	
	/********** Test for bidirectional one to many mapping **********/
/*
	@Test
	public void testCreateAuthor(){
		Author author = new Author();
		author.setName("Vaishali");

		Address address = new Address();
		address.setLocation("Faridabad");
		address.setStreetnumber(131);
		address.setState("Haryana");

		author.setAddress(address);


		Subject subject1 = new Subject();
		subject1.setSubName("Maths");

		Subject subject2 = new Subject();
		subject2.setSubName("English");

		Subject subject3 = new Subject();
		subject3.setSubName("Hindi");

		author.addSubject(subject1);
		author.addSubject(subject2);
		author.addSubject(subject3);


		Book book1 = new Book();
		book1.setBookName("Java");

		Book book2 = new Book();
		book2.setBookName("Cpp");

		author.addBook(book1);
		author.addBook(book2);

		authorRepository.save(author);
	}
*/

	/***** Test for unidirectional one to many mapping *****/
	@Test
	public void testCreateAuthor(){
		Author author = new Author();
		author.setName("Vaishali");

		Address address = new Address();
		address.setLocation("Faridabad");
		address.setStreetnumber(131);
		address.setState("Haryana");

		author.setAddress(address);

		List<Subject> subjects = new ArrayList<>();
		Subject subject1 = new Subject();
		subject1.setSubName("Maths");
		subject1.setAuthor(author);
		subjects.add(subject1);

		Subject subject2 = new Subject();
		subject2.setSubName("English");
		subject2.setAuthor(author);
		subjects.add(subject2);

		Subject subject3 = new Subject();
		subject3.setSubName("Hindi");
		subject3.setAuthor(author);
		subjects.add(subject3);

		author.setSubjects(subjects);

		List<Book> books = new ArrayList<>();
		Book book1 = new Book();
		book1.setBookName("Java");

		Book book2 = new Book();
		book2.setBookName("Cpp");

		books.add(book1);
		books.add(book2);

		author.setBooks(books);

		authorRepository.save(author);
	}

	@Test
	@Transactional
	public void testCaching(){
		Session session = entityManager.unwrap(Session.class);
		Author author = authorRepository.findById(1).get();
		authorRepository.findById(1).get(); // query will not be executed due to caching
		session.evict(author);				//removal of cached object
		authorRepository.findById(1).get(); //query will be executed
	}

	@Test
	public void testTransfer(){
		service.transfer(500);
	}

}

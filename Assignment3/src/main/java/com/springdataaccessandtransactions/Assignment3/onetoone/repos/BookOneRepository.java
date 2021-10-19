package com.springdataaccessandtransactions.Assignment3.onetoone.repos;

import com.springdataaccessandtransactions.Assignment3.onetoone.entities.BookOne;
import org.springframework.data.repository.CrudRepository;

public interface BookOneRepository extends CrudRepository<BookOne,Integer> {

}

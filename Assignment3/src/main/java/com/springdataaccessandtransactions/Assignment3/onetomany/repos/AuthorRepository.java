package com.springdataaccessandtransactions.Assignment3.onetomany.repos;

import com.springdataaccessandtransactions.Assignment3.onetomany.entities.*;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {

}

package com.springdataaccessandtransactions.Assignment3.manytomany.repos;

import com.springdataaccessandtransactions.Assignment3.manytomany.entities.AuthorMany;
import org.springframework.data.repository.CrudRepository;

public interface AuthorManyRepository extends CrudRepository<AuthorMany,Integer> {

}

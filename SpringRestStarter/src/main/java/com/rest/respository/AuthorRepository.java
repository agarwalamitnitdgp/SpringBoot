package com.rest.respository;

import org.springframework.data.repository.CrudRepository;

import com.rest.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}

package com.mongodb.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.mongodb.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, BigInteger> {

}

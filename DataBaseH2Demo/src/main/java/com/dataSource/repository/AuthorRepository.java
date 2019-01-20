package com.dataSource.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dataSource.bean.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}

package io.github.mimitwinkle.library.repositories;

import org.springframework.data.repository.CrudRepository;

import io.github.mimitwinkle.library.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}

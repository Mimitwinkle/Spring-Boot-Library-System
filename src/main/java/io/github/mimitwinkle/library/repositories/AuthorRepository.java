package io.github.mimitwinkle.library.repositories;

import org.springframework.data.repository.CrudRepository;

import io.github.mimitwinkle.library.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}

package io.github.mimitwinkle.library.repositories;

import org.springframework.data.repository.CrudRepository;

import io.github.mimitwinkle.library.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}

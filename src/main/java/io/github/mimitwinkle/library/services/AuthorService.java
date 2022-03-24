package io.github.mimitwinkle.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.mimitwinkle.library.domain.Author;
import io.github.mimitwinkle.library.repositories.AuthorRepository;

@Service
public class AuthorService {
	
	// this class is under construction
	
	@Autowired
	private AuthorRepository authorRepository;
	
	
	public void addAuthor(Author author) {
		authorRepository.save(author);
	}
}

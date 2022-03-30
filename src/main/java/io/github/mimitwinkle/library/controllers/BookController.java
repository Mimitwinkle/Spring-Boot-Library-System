package io.github.mimitwinkle.library.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.mimitwinkle.library.domain.Author;
import io.github.mimitwinkle.library.domain.Book;
import io.github.mimitwinkle.library.repositories.AuthorRepository;
import io.github.mimitwinkle.library.repositories.BookRepository;

@Controller
public class BookController {
	
	private final BookRepository bookRepository;
	
	private final AuthorRepository authorRepository;
	

	public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", bookRepository.findAll());
		
		return "books/list";
	}
	
	// handle navigation to new book form
	@GetMapping("/books/new")
	public String createbookForm(Model model) {
		
		Book book = new Book();
		model.addAttribute("book", book);
		
		Set<Author> authors = new HashSet<>();
		model.addAttribute("authors", authors);
		
		
		return "books/new";
	}
	
	// handle the creation of a new book using the form
	@PostMapping("/books")
	public String saveBook(@ModelAttribute("book") Book book, @ModelAttribute("authors") Set<Author> authors) {
		/*
		for( Author a : authors) {
			authorRepository.save(a);
		}
		*/
		authorRepository.saveAll(authors);
		bookRepository.save(book);
		
		return "redirect:/books";
	}
		
}

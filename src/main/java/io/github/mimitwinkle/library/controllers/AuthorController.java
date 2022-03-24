package io.github.mimitwinkle.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.mimitwinkle.library.domain.Author;
import io.github.mimitwinkle.library.repositories.AuthorRepository;
import io.github.mimitwinkle.library.services.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	private final AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}
	
	// handle the list of authors and add them to the view
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors", authorRepository.findAll());
		
		return "authors/list";
	}
	
	// handle navigation to new author form
	@GetMapping("/authors/new")
	public String createAuthorForm(Model model) {
		
		Author author = new Author();
		model.addAttribute("author", author);
		//authorService.addAuthor(null);
		
		return "authors/new";
	}
	
	// handle the creation of a new author using the form
	@PostMapping("/authors")
	public String saveAuthor(@ModelAttribute("author") Author author) {
		
		authorRepository.save(author);
		
		return "redirect:/authors";
	}
	
}

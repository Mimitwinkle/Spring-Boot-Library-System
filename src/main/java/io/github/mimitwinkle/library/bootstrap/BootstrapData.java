package io.github.mimitwinkle.library.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.github.mimitwinkle.library.domain.Author;
import io.github.mimitwinkle.library.domain.Book;
import io.github.mimitwinkle.library.domain.Publisher;
import io.github.mimitwinkle.library.repositories.AuthorRepository;
import io.github.mimitwinkle.library.repositories.BookRepository;
import io.github.mimitwinkle.library.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;


	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// publisher instantiation
		Publisher penguinRandomHouse = new Publisher();
		penguinRandomHouse.setName("Penguin Random House");
		penguinRandomHouse.setAddressLine1("1745 Broadway");
		penguinRandomHouse.setCity("New York");
		penguinRandomHouse.setState("NY");
		penguinRandomHouse.setZip("10019");
		
		publisherRepository.save(penguinRandomHouse);
		
		// author & book instantiation
		Author agathaChristie = new Author("Agatha", "Christie");
		Book attwn = new Book("And Then There Were None", "123123");
		agathaChristie.getBooks().add(attwn);
		attwn.getAuthors().add(agathaChristie);
		
		attwn.setPublisher(penguinRandomHouse);
		penguinRandomHouse.getBooks().add(attwn);
		
		authorRepository.save(agathaChristie);
		bookRepository.save(attwn);
		publisherRepository.save(penguinRandomHouse);
		
		Author janeAusten = new Author("Jane", "Austen");
		Book sas = new Book("Sense and Sensibility", "321321");
		janeAusten.getBooks().add(sas);
		sas.getAuthors().add(janeAusten);
		
		sas.setPublisher(penguinRandomHouse);
		penguinRandomHouse.getBooks().add(sas);
		
		authorRepository.save(janeAusten);
		bookRepository.save(sas);
		publisherRepository.save(penguinRandomHouse);
		
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Publishers: " + penguinRandomHouse);
		System.out.println(penguinRandomHouse.getName() + " number of books: " + penguinRandomHouse.getBooks().size());
		
		
	}
	
}

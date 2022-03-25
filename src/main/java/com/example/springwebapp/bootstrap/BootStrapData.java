package com.example.springwebapp.bootstrap;

import com.example.springwebapp.domain.Author;
import com.example.springwebapp.domain.Book;
import com.example.springwebapp.domain.Publisher;
import com.example.springwebapp.repository.AuthorRepository;
import com.example.springwebapp.repository.BookRepository;
import com.example.springwebapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher("Publishing", "505", "Cbe", "TN", "12423");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book domain_driven_design = new Book("Domain driven design", "122334");
        eric.getBooks().add(domain_driven_design);
        domain_driven_design.getAuthors().add(eric);
        domain_driven_design.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(domain_driven_design);

        Author rod = new Author("Rod", "Johnson");
        Book jee = new Book("J@EE", "31313131");

        rod.getBooks().add(jee);
        jee.getAuthors().add(rod);
        jee.setPublisher(publisher);

        publisher.getBooks().add(domain_driven_design);
        publisher.getBooks().add(jee);

        authorRepository.save(rod);
        bookRepository.save(jee);



        System.out.println("Started in bootstrap");
       System.out.println("Number of books "+ bookRepository.count());

    }
}

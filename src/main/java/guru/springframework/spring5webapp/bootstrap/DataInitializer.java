package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.AuthorUuid;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.BookUuid;
import guru.springframework.spring5webapp.repositories.AuthorUuidRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.BookUuidRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by João Nunes on 12/06/2023.
 */
@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {


    private final BookRepository bookRepository;
    private final AuthorUuidRepository authorUuidRepository;
    private final BookUuidRepository bookUuidRepository;

    public DataInitializer(BookRepository bookRepository, AuthorUuidRepository authorUuidRepository, BookUuidRepository bookUuidRepository) {
        this.bookRepository = bookRepository;
        this.authorUuidRepository = authorUuidRepository;
        this.bookUuidRepository = bookUuidRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        authorUuidRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse", null);
        Book savedDDD = bookRepository.save(bookDDD);

        Book bookSIA = new Book("Spring In Action", "234234", "Oriely", null);
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });



        AuthorUuid authorUuid = new AuthorUuid();
        authorUuid.setFirstName("Joe");
        authorUuid.setLastName("Buck");
        AuthorUuid savedAuthor = authorUuidRepository.save(authorUuid);
        System.out.println("Saved Author UUID: " + savedAuthor.getId() );

        BookUuid bookUuid = new BookUuid();
        bookUuid.setTitle("Spring Boot");
        BookUuid savedBook = bookUuidRepository.save(bookUuid);
        System.out.println("Saved Book UUID: " + savedBook.getId() );
    }
}
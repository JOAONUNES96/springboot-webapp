package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.domain.AuthorUuid;
import guru.springframework.spring5webapp.domain.BookNatural;
import guru.springframework.spring5webapp.domain.BookUuid;
import guru.springframework.spring5webapp.repositories.AuthorUuidRepository;
import guru.springframework.spring5webapp.repositories.BookNaturalRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.BookUuidRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by jt on 7/4/21.
 */
@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"guru.springframework.spring5webapp.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookUuidRepository bookUuidRepository;
    @Autowired
    AuthorUuidRepository authorUuidRepository;
    @Autowired
    BookNaturalRepository bookNaturalRepository;


    @Test
    void testMySQL() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
    }

    @Test
    void testAuthorUuidRepository() {
        AuthorUuid authorUuid = authorUuidRepository.save(new AuthorUuid());
        assertThat(authorUuid).isNotNull();
        assertThat(authorUuid.getId()).isNotNull();

        AuthorUuid fetchedAuthorUuid = authorUuidRepository.getById(authorUuid.getId());
        assertThat(fetchedAuthorUuid).isNotNull();
    }

    @Test
    void testBookUuidRepository() {
        BookUuid bookUuid = bookUuidRepository.save(new BookUuid());
        assertThat(bookUuid).isNotNull();
        assertThat(bookUuid.getId()).isNotNull();

        BookUuid fetchedBookUuid = bookUuidRepository.getById(bookUuid.getId());
        assertThat(fetchedBookUuid).isNotNull();
    }

    @Test
    void testBookNaturalRepository() {
        BookNatural bookNatural = new BookNatural();
        bookNatural.setTitle("title");
        BookNatural savedBookNatural = bookNaturalRepository.save(bookNatural);

        BookNatural fetchedBookNatural = bookNaturalRepository.getById(savedBookNatural.getTitle());
        assertThat(fetchedBookNatural).isNotNull();

    }
}



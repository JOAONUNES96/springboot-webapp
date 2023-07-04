package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.domain.AuthorUuid;
import guru.springframework.spring5webapp.domain.BookNatural;
import guru.springframework.spring5webapp.domain.BookUuid;
import guru.springframework.spring5webapp.domain.composite.AuthorComposite;
import guru.springframework.spring5webapp.domain.composite.AuthorEmbedded;
import guru.springframework.spring5webapp.domain.composite.NameId;
import guru.springframework.spring5webapp.repositories.*;
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
    @Autowired
    AuthorCompositeRepository authorCompositeRepository;
    @Autowired
    AuthorEmbeddedRepository authorEmbeddedRepository;

    @Test
    void testEmbeddedAuthor(){
        NameId nameId = new NameId("John", "Doe");
        AuthorEmbedded authorEmbedded = new AuthorEmbedded(nameId);

        AuthorEmbedded savedAuthorEmbedded = authorEmbeddedRepository.save(authorEmbedded);
        assertThat(savedAuthorEmbedded).isNotNull();

        AuthorEmbedded fetchedAuthorEmbedded = authorEmbeddedRepository.getById(nameId);
        assertThat(fetchedAuthorEmbedded).isNotNull();
    }

    @Test
    void testCompositeTest() {
        NameId nameId = new NameId("John", "Doe");
        AuthorComposite authorComposite = new AuthorComposite();
        authorComposite.setFirstName(nameId.getFirstName());
        authorComposite.setLastName(nameId.getLastName());
        authorComposite.setCountry("USA");

        AuthorComposite savedAuthorComposite = authorCompositeRepository.save(authorComposite); //saves the authorComposite object to the database
        assertThat(savedAuthorComposite).isNotNull();

        AuthorComposite fetchedAuthorComposite = authorCompositeRepository.getById(nameId); //fetches the authorComposite object from the database
        assertThat(fetchedAuthorComposite).isNotNull(); //asserts that the fetched authorComposite object is not null
    }


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



package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by João Nunes on 12/06/2023.
 */
// I could also have used the annotations
public interface BookRepository extends JpaRepository<Book, Long> {
}

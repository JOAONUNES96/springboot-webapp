package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.BookNatural;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookNaturalRepository extends JpaRepository<BookNatural, String> {
}

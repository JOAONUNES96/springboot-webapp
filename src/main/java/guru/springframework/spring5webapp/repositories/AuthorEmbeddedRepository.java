package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.composite.AuthorEmbedded;
import guru.springframework.spring5webapp.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId>{


}

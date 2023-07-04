package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.composite.AuthorComposite;
import guru.springframework.spring5webapp.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}

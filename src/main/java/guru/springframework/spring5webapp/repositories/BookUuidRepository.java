package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.BookUuid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by jn on 27/06/23.
 */
public interface BookUuidRepository extends JpaRepository<BookUuid, UUID> {
}
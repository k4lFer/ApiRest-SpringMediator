package kalfer.apis_pring.Infrastructure.Persistence.Jpa;

import kalfer.apis_pring.Domain.Entities.TUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<TUser, UUID> {
    Page<TUser> findByNameContainingIgnoreCase(String name, Pageable pageable);
}

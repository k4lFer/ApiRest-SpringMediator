package kalfer.apis_pring.Infrastructure.Persistence.Repositories;

import kalfer.apis_pring.Domain.Entities.TUser;
import kalfer.apis_pring.Domain.Interfaces.Repositories.IUserRepository;
import kalfer.apis_pring.Infrastructure.Persistence.Jpa.UserJpaRepository;
import kalfer.apis_pring.Infrastructure.Persistence.Repositories.Generic.GenericRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserRepository extends GenericRepository<TUser, UUID> implements IUserRepository {
    private final UserJpaRepository userJpaRepository;

    public UserRepository(JpaRepository<TUser, UUID> jpaRepository, UserJpaRepository userJpaRepository) {
        super(jpaRepository);
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Page<TUser> GetAllUserPaged(Pageable pageable, String search) {
        if (search != null && !search.isEmpty()) {
            return userJpaRepository.findByNameContainingIgnoreCase(search, pageable);
        }
        else{
            return userJpaRepository.findAll(pageable);
        } 
    }

    @Override
    public TUser GetByEmail(String email) {
        return userJpaRepository.findByEmail(email);
    }

}

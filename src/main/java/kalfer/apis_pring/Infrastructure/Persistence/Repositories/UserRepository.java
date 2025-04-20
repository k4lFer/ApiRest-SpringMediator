package kalfer.apis_pring.Infrastructure.Persistence.Repositories;

import kalfer.apis_pring.Domain.Common.PagedResult;
import kalfer.apis_pring.Domain.Entities.TUser;
import kalfer.apis_pring.Domain.Interfaces.Repositories.IUserRepository;
import kalfer.apis_pring.Infrastructure.Persistence.Jpa.UserJpaRepository;
import kalfer.apis_pring.Infrastructure.Persistence.Repositories.Generic.GenericRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public PagedResult<TUser> GetAllUserPaged(int pageNumber, int pageSize, String search) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<TUser> page;

        if (search != null && !search.isEmpty()) {
            page = userJpaRepository.findByNameContainingIgnoreCase(search, pageable);
        } else {
            page = userJpaRepository.findAll(pageable);
        }

        return new PagedResult<>(
                page.getContent(),
                (int) page.getTotalElements(),
                pageNumber,
                pageSize
        );
    }

}

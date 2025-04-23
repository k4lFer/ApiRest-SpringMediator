package kalfer.apis_pring.Domain.Interfaces.Repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kalfer.apis_pring.Domain.Entities.TUser;
import kalfer.apis_pring.Domain.Interfaces.Generic.IGenericRepository;

public interface IUserRepository extends IGenericRepository<TUser>
{
    Page<TUser> GetAllUserPaged(Pageable pageable, String search);
    TUser GetByEmail(String email);
}
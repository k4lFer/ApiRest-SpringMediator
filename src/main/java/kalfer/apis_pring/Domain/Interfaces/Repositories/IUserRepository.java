package kalfer.apis_pring.Domain.Interfaces.Repositories;

import kalfer.apis_pring.Domain.Common.PagedResult;
import kalfer.apis_pring.Domain.Entities.TUser;
import kalfer.apis_pring.Domain.Interfaces.Generic.IGenericRepository;

public interface IUserRepository extends IGenericRepository<TUser>
{
    PagedResult<TUser> GetAllUserPaged(int pageNumber, int pageSize, String search);
}
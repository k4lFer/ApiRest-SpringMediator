package kalfer.apis_pring.Domain.Interfaces.Generic;

import java.util.Optional;
import java.util.UUID;

public interface IGenericRepository<T> {
    T Create(T entity);
    T Update(T entity);
    Optional<T> Get(UUID Id);
    void Delete(UUID Id);
}

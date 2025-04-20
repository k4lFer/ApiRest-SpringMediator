package kalfer.apis_pring.Infrastructure.Persistence.Repositories.Generic;

import kalfer.apis_pring.Domain.Interfaces.Generic.IGenericRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public abstract class GenericRepository<T, ID> implements IGenericRepository<T>{
    protected final JpaRepository<T, ID> jpaRepository;
    
    @Override
    public T Create(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public T Update(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<T> Get(UUID Id) {
        return jpaRepository.findById((ID) Id);
    }

    @Override
    public void Delete(UUID Id) {
        jpaRepository.deleteById((ID) Id);
    }
}

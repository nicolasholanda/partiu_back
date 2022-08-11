package com.github.nicolasholanda.partiubackend.service;

import com.github.nicolasholanda.partiubackend.model.BaseEntity;
import com.github.nicolasholanda.partiubackend.repository.BaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import static java.lang.String.format;

@AllArgsConstructor
public abstract class BaseService<T extends BaseEntity<T>> {

    private final BaseRepository<T> repository;

    public Page<T> findPaginated(Pageable pageable){
        return repository.findAll(pageable);
    }

    public T findById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new NoResultException(format("Objeto de id %s não foi encontrado.", id))
        );
    }

    @Transactional
    public T update(T updated){
        T dbDomain = findById(updated.getId());
        dbDomain.update(updated);

        return repository.save(dbDomain);
    }

    @Transactional
    public T save(T object){
        return repository.save(object);
    }

    @Transactional
    public void delete(Long id){
        findById(id);
        repository.deleteById(id);
    }
}

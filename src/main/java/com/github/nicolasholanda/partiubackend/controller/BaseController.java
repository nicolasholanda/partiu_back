package com.github.nicolasholanda.partiubackend.controller;

import com.github.nicolasholanda.partiubackend.model.BaseEntity;
import com.github.nicolasholanda.partiubackend.service.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@AllArgsConstructor
public abstract class BaseController<T extends BaseEntity<T>> {

    protected final BaseService<T> service;

    @GetMapping
    public Page<T> findPaginated(Pageable pageable) {
        return service.findPaginated(pageable);
    }

    @GetMapping("{id}")
    public T findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping
    public T update(@Valid @RequestBody T updated){
        return service.update(updated);
    }

    @PostMapping
    public T save(@RequestBody T created){
        return service.save(created);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}

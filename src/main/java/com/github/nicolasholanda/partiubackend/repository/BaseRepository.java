package com.github.nicolasholanda.partiubackend.repository;

import com.github.nicolasholanda.partiubackend.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity<T>> extends JpaRepository<T, Long> {
}

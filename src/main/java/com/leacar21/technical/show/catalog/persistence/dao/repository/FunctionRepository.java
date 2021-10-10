package com.leacar21.technical.show.catalog.persistence.dao.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leacar21.technical.show.catalog.persistence.model.Function;

public interface FunctionRepository extends JpaRepository<Function, Long> {

    Optional<Function> findByCode(UUID code);

}
package com.leacar21.technical.show.catalog.persistence.dao.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leacar21.technical.show.catalog.persistence.model.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

    public Optional<Show> findByCode(UUID code);

    public List<Show> findByEnabled(boolean enabled);

}
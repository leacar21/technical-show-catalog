package com.leacar21.technical.show.catalog.persistence.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leacar21.technical.show.catalog.persistence.dao.repository.ShowRepository;
import com.leacar21.technical.show.catalog.persistence.model.Show;

@Repository
public class ShowDAO {

    @Autowired
    private ShowRepository repository;

    @Transactional(readOnly = true)
    public Show findByCode(UUID code) {
        Optional<Show> optionalTheater = this.repository.findByCode(code);
        return optionalTheater.isPresent() ? optionalTheater.get() : null;
    }

    @Transactional(readOnly = false)
    public Show save(Show entity) {
        return this.repository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<Show> findAll(boolean enabled) {
        return this.repository.findByEnabled(enabled);
    }

    @Transactional(readOnly = true)
    public List<Show> findAll() {
        return this.repository.findAll();
    }
}

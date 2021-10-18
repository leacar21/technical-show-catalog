package com.leacar21.technical.show.catalog.persistence.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leacar21.technical.show.catalog.persistence.dao.repository.FunctionRepository;
import com.leacar21.technical.show.catalog.persistence.model.Function;

@Repository
public class FunctionDAO {

    @Autowired
    private FunctionRepository repository;

    @Transactional(readOnly = true)
    public Function findByCode(UUID code) {
        Optional<Function> optionalFunction = this.repository.findByCode(code);
        return optionalFunction.isPresent() ? optionalFunction.get() : null;
    }

}

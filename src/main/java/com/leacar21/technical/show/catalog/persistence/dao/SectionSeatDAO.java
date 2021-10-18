package com.leacar21.technical.show.catalog.persistence.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leacar21.technical.show.catalog.exceptions.ResourceNotFoundException;
import com.leacar21.technical.show.catalog.persistence.dao.repository.SectionSeatRepository;
import com.leacar21.technical.show.catalog.persistence.model.SectionSeat;

@Repository
public class SectionSeatDAO {

    @Autowired
    private SectionSeatRepository repository;

    @Transactional(readOnly = false)
    public SectionSeat updateAvailable(UUID code, boolean available) {
        var optionalSectionSeat = this.repository.findByCode(code);
        if (optionalSectionSeat.isEmpty()) {
            throw new ResourceNotFoundException("SectionSeat not found");
        }

        var sectionSeat = optionalSectionSeat.get();
        sectionSeat.setAvailable(available);
        this.repository.save(sectionSeat);

        return sectionSeat;
    }

}

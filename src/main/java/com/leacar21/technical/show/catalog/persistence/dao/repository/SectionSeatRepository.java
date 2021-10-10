package com.leacar21.technical.show.catalog.persistence.dao.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leacar21.technical.show.catalog.persistence.model.SectionSeat;

public interface SectionSeatRepository extends JpaRepository<SectionSeat, Long> {

    Optional<SectionSeat> findByCode(UUID code);

    // @Modifying
    // @Query("update SectionSeat s set s.available = :available where s.code = :code")
    // void updateAvailable(@Param(value = "code") UUID code, @Param(value = "available") boolean available);

}
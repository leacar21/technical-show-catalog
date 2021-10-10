package com.leacar21.technical.show.catalog.services;

import java.util.List;

import com.leacar21.technical.show.catalog.dto.SectionSeatDTO;

public interface SectionSeatService {

    SectionSeatDTO updateAvailable(String code, Boolean available);

    List<SectionSeatDTO> getByFunction(String functionCode);

}

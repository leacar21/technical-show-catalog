package com.leacar21.technical.show.catalog.converters;

import org.springframework.stereotype.Service;

import com.leacar21.technical.show.catalog.dto.SectionSeatDTO;
import com.leacar21.technical.show.catalog.persistence.model.SectionSeat;

@Service
public class SectionSeatConverter extends AbstractConverter<SectionSeatDTO, SectionSeat> {

    @Override
    protected SectionSeat commonToEntity(SectionSeatDTO source) {
        return this.strictModelMapper.map(source, SectionSeat.class);
    }

    @Override
    protected SectionSeatDTO commonToDTO(SectionSeat source) {
        var sectionSeatDTO = this.strictModelMapper.map(source, SectionSeatDTO.class);
        sectionSeatDTO.setSectionCode(source.getSection().getCode().toString());
        return sectionSeatDTO;
    }

}
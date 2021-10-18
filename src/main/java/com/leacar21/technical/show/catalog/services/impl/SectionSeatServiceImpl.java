package com.leacar21.technical.show.catalog.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.leacar21.technical.show.catalog.converters.SectionSeatConverter;
import com.leacar21.technical.show.catalog.dto.SectionSeatDTO;
import com.leacar21.technical.show.catalog.exceptions.ResourceNotFoundException;
import com.leacar21.technical.show.catalog.persistence.dao.FunctionDAO;
import com.leacar21.technical.show.catalog.persistence.dao.SectionSeatDAO;
import com.leacar21.technical.show.catalog.services.SectionSeatService;

@Service
public class SectionSeatServiceImpl implements SectionSeatService {

    @Autowired
    private SectionSeatDAO sectionSeatDAO;

    @Autowired
    private FunctionDAO functionDAO;

    @Autowired
    private SectionSeatConverter sectionSeatConverter;

    @Override
    public SectionSeatDTO updateAvailable(String code, Boolean available) {

        UUID uuidCode = null;
        try {
            uuidCode = UUID.fromString(code);
        } catch (Exception exc) {
            throw new ResourceNotFoundException("SectionSeat not found");
        }

        var sectionSeat = this.sectionSeatDAO.updateAvailable(uuidCode, available.booleanValue());
        return this.sectionSeatConverter.toDTO(sectionSeat);
    }

    @Override
    public List<SectionSeatDTO> getByFunction(String functionCode) {
        UUID uuidCode = null;
        try {
            uuidCode = UUID.fromString(functionCode);
        } catch (Exception exc) {
            throw new ResourceNotFoundException("Function not found");
        }

        var function = this.functionDAO.findByCode(uuidCode);

        var auditoriumFunctionLayout = function.getAuditoriumFunctionLayout();
        if ((auditoriumFunctionLayout == null) || (CollectionUtils.isEmpty(auditoriumFunctionLayout.getSections()))) {
            return List.of();
        }

        var listSectionSeat = auditoriumFunctionLayout.getSections().stream() //
                .flatMap(s -> s.getSectionSeats().stream()) //
                .collect(Collectors.toList());

        return this.sectionSeatConverter.toDTO(listSectionSeat);
    }

}

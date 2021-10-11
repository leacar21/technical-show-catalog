package com.leacar21.technical.show.catalog.services.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.leacar21.technical.show.catalog.dto.ShowDTO;

public abstract class FilterShow {

    // Se aplica patrón Themplate Method

    public List<ShowDTO> filter(List<ShowDTO> listShowDTO) {
        return listShowDTO.stream().filter(this::satisfyCondition).collect(Collectors.toList());
    }

    protected abstract boolean satisfyCondition(ShowDTO s);

}

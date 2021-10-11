package com.leacar21.technical.show.catalog.services.filters;

import java.util.Date;

import com.leacar21.technical.show.catalog.dto.ShowDTO;

public class FilterFunctionDateTo extends FilterShow {

    private Date dateTo;

    public FilterFunctionDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    protected boolean satisfyCondition(ShowDTO s) {
        // Existe al menos una función con fecha anterior a dateTo
        return s.getFunctions().stream().anyMatch(f -> f.getDate().before(this.dateTo));
    }

}

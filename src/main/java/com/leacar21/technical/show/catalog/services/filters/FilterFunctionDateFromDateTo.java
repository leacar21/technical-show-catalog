package com.leacar21.technical.show.catalog.services.filters;

import java.util.Date;

import com.leacar21.technical.show.catalog.dto.ShowDTO;

public class FilterFunctionDateFromDateTo extends FilterShow {

    private Date dateFrom;
    private Date dateTo;

    public FilterFunctionDateFromDateTo(Date dateFrom, Date dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    @Override
    protected boolean satisfyCondition(ShowDTO s) {
        // Existe al menos una función con fecha posterior a dateFrom y fecha anterior a dateTo
        return s.getFunctions().stream() //
                .anyMatch(f -> f.getDate().after(this.dateFrom) && f.getDate().before(this.dateTo));
    }

}

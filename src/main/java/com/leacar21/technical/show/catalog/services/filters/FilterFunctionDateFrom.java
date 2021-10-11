package com.leacar21.technical.show.catalog.services.filters;

import java.util.Date;

import com.leacar21.technical.show.catalog.dto.ShowDTO;

public class FilterFunctionDateFrom extends FilterShow {

    private Date dateFrom;

    public FilterFunctionDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Override
    protected boolean satisfyCondition(ShowDTO s) {
        // Existe al menos una función con fecha posterior a dateFrom
        return s.getFunctions().stream().anyMatch(f -> f.getDate().after(this.dateFrom));
    }

}

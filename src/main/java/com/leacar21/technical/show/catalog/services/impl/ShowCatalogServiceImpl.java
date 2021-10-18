package com.leacar21.technical.show.catalog.services.impl;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.leacar21.technical.show.catalog.dto.FunctionDTO;
import com.leacar21.technical.show.catalog.dto.ShowDTO;
import com.leacar21.technical.show.catalog.dto.enums.OrderDirection;
import com.leacar21.technical.show.catalog.dto.enums.ShowOrderBy;
import com.leacar21.technical.show.catalog.services.ShowCatalogService;
import com.leacar21.technical.show.catalog.services.internal.ShowCatalogInternalService;

@Service
public class ShowCatalogServiceImpl implements ShowCatalogService {

    Logger log = LoggerFactory.getLogger(ShowCatalogServiceImpl.class);

    @Autowired
    private ShowCatalogInternalService showCatalogInternalService;

    @Override
    public ShowDTO create(ShowDTO showDTO) {
        return this.showCatalogInternalService.create(showDTO);
    }

    @Override
    public List<ShowDTO> getAll(Boolean enabled, Date functionDateFrom, Date functionDateTo, BigDecimal seatPriceFrom,
            BigDecimal seatPriceTo, ShowOrderBy orderBy, OrderDirection orderDirection) {
        var listShowDTO = this.showCatalogInternalService.getAll(enabled);

        var resultListShowDTO = this.filterResults(functionDateFrom, functionDateTo, seatPriceFrom, seatPriceTo, listShowDTO);
        resultListShowDTO = this.sortResults(orderBy, orderDirection, resultListShowDTO);

        return resultListShowDTO;
    }

    // =============================

    private List<ShowDTO> filterResults(Date functionDateFrom, Date functionDateTo, BigDecimal seatPriceFrom, BigDecimal seatPriceTo,
            List<ShowDTO> listShowDTO) {
        var resultListShowDTO = new LinkedList<ShowDTO>();

        for (ShowDTO showDTO : listShowDTO) {

            var resultShowDTO = ShowDTO.builder() //
                                       .code(showDTO.getCode()) //
                                       .enabled(showDTO.isEnabled()) //
                                       .name(showDTO.getName());

            var resultListFunctionDTO = new LinkedList<FunctionDTO>();
            for (FunctionDTO functionDTO : showDTO.getFunctions()) {
                if (this.satisfyDateFrom(functionDateFrom, functionDTO) && //
                        this.satisfyDateTo(functionDateTo, functionDTO) && //
                        this.satisfyPriceFrom(seatPriceFrom, functionDTO) && //
                        this.satisfyPriceTo(seatPriceTo, functionDTO)) {
                    resultListFunctionDTO.add(functionDTO);
                }
            }

            if (!CollectionUtils.isEmpty(resultListFunctionDTO)) {
                resultShowDTO.functions(resultListFunctionDTO);
                resultListShowDTO.add(resultShowDTO.build());
            }

        }
        return resultListShowDTO;
    }

    private boolean satisfyDateFrom(Date functionDateFrom, FunctionDTO functionDTO) {
        var functionDate = functionDTO.getDate();
        return (functionDateFrom == null) || //
                functionDate.equals(functionDateFrom) || //
                functionDate.after(functionDateFrom);
    }

    private boolean satisfyDateTo(Date functionDateTo, FunctionDTO functionDTO) {
        var functionDate = functionDTO.getDate();
        return (functionDateTo == null) || //
                functionDate.equals(functionDateTo) || //
                functionDate.before(functionDateTo);
    }

    private boolean satisfyPriceFrom(BigDecimal seatPriceFrom, FunctionDTO functionDTO) {
        return (seatPriceFrom == null) || functionDTO.getAuditoriumFunctionLayout()
                                                     .getSections()
                                                     .stream()
                                                     .anyMatch(s -> s.getSeatPrice()
                                                                     .compareTo(seatPriceFrom) >= 0);
    }

    private boolean satisfyPriceTo(BigDecimal seatPriceTo, FunctionDTO functionDTO) {
        return (seatPriceTo == null) || functionDTO.getAuditoriumFunctionLayout()
                                                   .getSections()
                                                   .stream()
                                                   .anyMatch(s -> s.getSeatPrice()
                                                                   .compareTo(seatPriceTo) <= 0);
    }

    // =============================

    private List<ShowDTO> sortResults(ShowOrderBy orderBy, OrderDirection orderDirection, List<ShowDTO> listShowDTO) {
        if (orderBy == null) {
            return listShowDTO;
        }
        switch (orderBy) {
            case NAME:
                return sortResultsByName(orderDirection, listShowDTO);
            case FUNCTION_DATE:
                return sortResultsByDate(orderDirection, listShowDTO);
            case FUNCTION_SECTION_PRICE:
                return sortResultsBySectionPrice(orderDirection, listShowDTO);
            default:
                return listShowDTO;
        }

    }

    private List<ShowDTO> sortResultsByName(OrderDirection orderDirection, List<ShowDTO> listShowDTO) {
        if (OrderDirection.DESC.equals(orderDirection)) {
            return listShowDTO.stream()
                              .sorted(Comparator.comparing(ShowDTO::getName)
                                                .reversed())
                              .collect(Collectors.toList());
        } else {
            return listShowDTO.stream()
                              .sorted(Comparator.comparing(ShowDTO::getName))
                              .collect(Collectors.toList());
        }
    }

    private List<ShowDTO> sortResultsBySectionPrice(OrderDirection orderDirection, List<ShowDTO> listShowDTO) {
        if (OrderDirection.DESC.equals(orderDirection)) {
            return listShowDTO.stream()
                              .sorted(Comparator.comparing(ShowDTO::getMaxFunctionPrice)
                                                .reversed())
                              .collect(Collectors.toList());
        } else {
            return listShowDTO.stream()
                              .sorted(Comparator.comparing(ShowDTO::getMinFunctionPrice))
                              .collect(Collectors.toList());
        }
    }

    private List<ShowDTO> sortResultsByDate(OrderDirection orderDirection, List<ShowDTO> listShowDTO) {
        if (OrderDirection.DESC.equals(orderDirection)) {
            return listShowDTO.stream()
                              .sorted(Comparator.comparing(ShowDTO::getNextFunctionDate)
                                                .reversed())
                              .collect(Collectors.toList());
        } else {
            return listShowDTO.stream()
                              .sorted(Comparator.comparing(ShowDTO::getNextFunctionDate))
                              .collect(Collectors.toList());
        }
    }

}

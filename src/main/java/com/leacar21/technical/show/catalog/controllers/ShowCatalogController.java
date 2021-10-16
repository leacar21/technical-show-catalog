package com.leacar21.technical.show.catalog.controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leacar21.technical.show.catalog.dto.ShowDTO;
import com.leacar21.technical.show.catalog.dto.enums.OrderDirection;
import com.leacar21.technical.show.catalog.dto.enums.ShowOrderBy;
import com.leacar21.technical.show.catalog.services.ShowCatalogService;

@RestController()
@RequestMapping(ShowCatalogController.SHOWS_RESOURCE)
public class ShowCatalogController {

    public static final String SHOWS_RESOURCE = "shows";

    @Autowired
    private ShowCatalogService showCatalogService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShowDTO> getAll( //
            @RequestParam(value = "enabled", required = false) Boolean enabled, //
            @RequestParam(value = "functionDateFrom", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date functionDateFrom, //
            @RequestParam(value = "functionDateTo", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date functionDateTo, //
            @RequestParam(value = "seatPriceFrom", required = false) BigDecimal seatPriceFrom, //
            @RequestParam(value = "seatPriceTo", required = false) BigDecimal seatPriceTo, //
            @RequestParam(value = "orderBy", required = false) ShowOrderBy orderBy, //
            @RequestParam(value = "orderDirection", required = false) OrderDirection orderDirection //
    ) {
        return this.showCatalogService.getAll(enabled, functionDateFrom, functionDateTo, seatPriceFrom, seatPriceTo, orderBy,
                orderDirection);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ShowDTO create(@RequestBody(required = true) ShowDTO theaterDTO) {
        return this.showCatalogService.create(theaterDTO);
    }

}

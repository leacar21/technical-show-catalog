package com.leacar21.technical.show.catalog.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("shows")
public class ShowCatalogController {

    Logger log = LoggerFactory.getLogger(ShowCatalogController.class);

    @Autowired
    private ShowCatalogService showCatalogService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShowDTO> getAll( //
            @RequestParam(value = "enabled", required = false) Boolean enabled, //
            @RequestParam(value = "functionDateFrom", required = false) Date functionDateFrom, //
            @RequestParam(value = "functionDateTo", required = false) Date functionDateTo, //
            @RequestParam(value = "seatPriceFrom", required = false) Date seatPriceFrom, //
            @RequestParam(value = "seatPriceTo", required = false) Date seatPriceTo, //
            @RequestParam(value = "orderBy", required = false) ShowOrderBy orderBy, //
            @RequestParam(value = "orderDirection", required = false) OrderDirection orderDirection //
    ) {
        return this.showCatalogService.getAll(enabled, functionDateFrom, functionDateTo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ShowDTO create(@RequestBody(required = true) ShowDTO theaterDTO) {
        return this.showCatalogService.create(theaterDTO);
    }

}

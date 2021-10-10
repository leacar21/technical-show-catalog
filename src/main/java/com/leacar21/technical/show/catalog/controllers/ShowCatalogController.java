package com.leacar21.technical.show.catalog.controllers;

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
import com.leacar21.technical.show.catalog.services.ShowCatalogService;

@RestController()
@RequestMapping("shows")
public class ShowCatalogController {

    Logger log = LoggerFactory.getLogger(ShowCatalogController.class);

    @Autowired
    private ShowCatalogService showCatalogService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShowDTO> getAll(@RequestParam(value = "enabled", required = false) Boolean enabled) {
        return this.showCatalogService.getAll(enabled);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ShowDTO create(@RequestBody(required = true) ShowDTO theaterDTO) {
        return this.showCatalogService.create(theaterDTO);
    }

}

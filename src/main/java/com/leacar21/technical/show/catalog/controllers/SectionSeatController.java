package com.leacar21.technical.show.catalog.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leacar21.technical.show.catalog.services.SectionSeatService;

@RestController()
@RequestMapping("shows")
public class SectionSeatController {

    Logger log = LoggerFactory.getLogger(SectionSeatController.class);

    @Autowired
    private SectionSeatService sectionSeatService;

    // @PatchMapping
    // @ResponseStatus(HttpStatus.OK)
    // public SectionSeatDTO update(@RequestBody(required = true) SectionSeatDTO sectionSeatDTO) {
    // return this.sectionSeatDTOService.update(sectionSeatDTO);
    // }

}

package com.leacar21.technical.show.catalog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leacar21.technical.show.catalog.dto.SectionSeatDTO;
import com.leacar21.technical.show.catalog.services.SectionSeatService;

@RestController()
@RequestMapping("section-seat")
public class SectionSeatController {

    Logger log = LoggerFactory.getLogger(SectionSeatController.class);

    @Autowired
    private SectionSeatService sectionSeatService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<SectionSeatDTO> getByFunction(@RequestParam(value = "function-code", required = true) String functionCode) {
        return this.sectionSeatService.getByFunction(functionCode);
    }

    @PatchMapping(value = "/{code}")
    @ResponseStatus(HttpStatus.OK)
    public SectionSeatDTO update(@PathVariable("code") String code, @Valid @RequestBody(required = true) SectionSeatDTO sectionSeatDTO) {
        return this.sectionSeatService.updateAvailable(code, sectionSeatDTO.getAvailable());
    }

}

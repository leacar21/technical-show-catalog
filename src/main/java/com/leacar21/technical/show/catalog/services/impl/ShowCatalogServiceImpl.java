package com.leacar21.technical.show.catalog.services.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leacar21.technical.show.catalog.converters.ShowConverter;
import com.leacar21.technical.show.catalog.dto.ShowDTO;
import com.leacar21.technical.show.catalog.persistence.dao.ShowDAO;
import com.leacar21.technical.show.catalog.persistence.model.Show;
import com.leacar21.technical.show.catalog.services.ShowCatalogService;

@Service
public class ShowCatalogServiceImpl implements ShowCatalogService {

    Logger log = LoggerFactory.getLogger(ShowCatalogServiceImpl.class);

    @Autowired
    private ShowDAO showDAO;

    @Autowired
    private ShowConverter showConverter;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "shows", unless = "#result.size() == 0")
    public List<ShowDTO> getAll(Boolean enabled, Date functionDateFrom, Date functionDateTo) {
        List<Show> listTheater = null;
        if (enabled == null) {
            listTheater = this.showDAO.findAll();
        } else {
            listTheater = this.showDAO.findAll(enabled);
        }

        return this.showConverter.toDTO(listTheater);
    }

    @Override
    @Transactional(readOnly = false)
    public ShowDTO create(ShowDTO showDTO) {
        var show = this.showConverter.toEntity(showDTO);
        show = this.showDAO.save(show);
        return this.showConverter.toDTO(show);
    }

}

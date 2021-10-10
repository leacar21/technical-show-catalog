package com.leacar21.technical.show.catalog.converters;

import org.springframework.stereotype.Service;

import com.leacar21.technical.show.catalog.dto.ShowDTO;
import com.leacar21.technical.show.catalog.persistence.model.Show;

@Service
public class ShowConverter extends AbstractConverter<ShowDTO, Show> {

    @Override
    protected Show commonToEntity(ShowDTO source) {
        return this.strictModelMapper.map(source, Show.class);
    }

    @Override
    protected ShowDTO commonToDTO(Show source) {
        return this.strictModelMapper.map(source, ShowDTO.class);
    }

}
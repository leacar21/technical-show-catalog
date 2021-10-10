package com.leacar21.technical.show.catalog.services;

import java.util.List;

import com.leacar21.technical.show.catalog.dto.ShowDTO;

public interface ShowCatalogService {

    List<ShowDTO> getAll(Boolean enabled);

    ShowDTO create(ShowDTO theaterDTO);

}

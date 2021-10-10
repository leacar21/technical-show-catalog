package com.leacar21.technical.show.catalog.services;

import java.util.Date;
import java.util.List;

import com.leacar21.technical.show.catalog.dto.ShowDTO;

public interface ShowCatalogService {

    List<ShowDTO> getAll(Boolean enabled, Date functionDateFrom, Date functionDateTo);

    ShowDTO create(ShowDTO theaterDTO);

}

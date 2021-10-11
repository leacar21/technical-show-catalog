package com.leacar21.technical.show.catalog.services.internal;

import java.util.List;

import com.leacar21.technical.show.catalog.dto.ShowDTO;

public interface ShowCatalogInternalService {

    List<ShowDTO> getAll(Boolean enabled);

    ShowDTO create(ShowDTO theaterDTO);

}

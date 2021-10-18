package com.leacar21.technical.show.catalog.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.leacar21.technical.show.catalog.dto.ShowDTO;
import com.leacar21.technical.show.catalog.dto.enums.OrderDirection;
import com.leacar21.technical.show.catalog.dto.enums.ShowOrderBy;

public interface ShowCatalogService {

    List<ShowDTO> getAll(Boolean enabled, Date functionDateFrom, Date functionDateTo, BigDecimal seatPriceFrom, BigDecimal seatPriceTo,
            ShowOrderBy orderBy, OrderDirection orderDirection);

    ShowDTO create(ShowDTO theaterDTO);

}

package com.leacar21.technical.show.catalog.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SectionDTO {

    private String code;

    private String name;

    private BigDecimal seatPrice;

    private List<SectionSeatDTO> sectionSeat;

}

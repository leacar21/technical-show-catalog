package com.leacar21.technical.show.catalog.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuditoriumFunctionLayoutDTO {

    private String code;

    private String name;

    private List<SectionDTO> sections;

    private String auditoriumCode;

}

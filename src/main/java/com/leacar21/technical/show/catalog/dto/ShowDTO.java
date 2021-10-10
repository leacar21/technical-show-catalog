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
public class ShowDTO {

    private String code;

    private String name;

    private boolean enabled;

    private List<FunctionDTO> functions;

}

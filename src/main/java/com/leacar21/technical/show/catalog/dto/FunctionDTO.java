package com.leacar21.technical.show.catalog.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FunctionDTO {

    private String code;

    private Date date;

    private boolean enabled;

    private AuditoriumFunctionLayoutDTO auditoriumFunctionLayout;

}

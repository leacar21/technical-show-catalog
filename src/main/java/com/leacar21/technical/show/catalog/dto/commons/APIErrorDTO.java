package com.leacar21.technical.show.catalog.dto.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIErrorDTO {

    private int code;
    private String message;
}

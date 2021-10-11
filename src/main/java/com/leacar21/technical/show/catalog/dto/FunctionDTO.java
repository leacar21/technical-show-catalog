package com.leacar21.technical.show.catalog.dto;

import java.util.Comparator;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    // ----------------

    @JsonIgnore
    public double getMinSectorPrice() {
        var optionalSection = this.auditoriumFunctionLayout.getSections().stream().min(Comparator.comparing(SectionDTO::getSeatPrice));
        if (optionalSection.isEmpty()) {
            return 0;
        }
        return optionalSection.get().getSeatPrice().doubleValue();
    }

    @JsonIgnore
    public double getMaxSectorPrice() {
        var optionalSection = this.auditoriumFunctionLayout.getSections().stream().max(Comparator.comparing(SectionDTO::getSeatPrice));
        if (optionalSection.isEmpty()) {
            return 0;
        }
        return optionalSection.get().getSeatPrice().doubleValue();
    }

}

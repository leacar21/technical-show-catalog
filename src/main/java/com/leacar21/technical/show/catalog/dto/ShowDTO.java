package com.leacar21.technical.show.catalog.dto;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    // ----------------

    @JsonIgnore
    public Date getNextFunctionDate() {
        var optionalFunction = this.functions.stream().max(Comparator.comparing(FunctionDTO::getDate));
        if (optionalFunction.isEmpty()) {
            return null;
        }
        return optionalFunction.get().getDate();
    }

    @JsonIgnore
    public Double getMinFunctionPrice() {
        var optionalFunction = this.functions.stream().min(Comparator.comparingDouble(FunctionDTO::getMinSectorPrice));
        if (optionalFunction.isEmpty()) {
            return null;
        }
        return optionalFunction.get().getMinSectorPrice();
    }

    @JsonIgnore
    public Double getMaxFunctionPrice() {
        var optionalFunction = this.functions.stream().max(Comparator.comparingDouble(FunctionDTO::getMaxSectorPrice));
        if (optionalFunction.isEmpty()) {
            return null;
        }
        return optionalFunction.get().getMaxSectorPrice();
    }

}

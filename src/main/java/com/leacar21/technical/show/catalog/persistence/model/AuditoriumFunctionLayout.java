package com.leacar21.technical.show.catalog.persistence.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auditorium_function_layout")
public class AuditoriumFunctionLayout extends AbstractEntityJPA {

    @Column(name = "code", columnDefinition = "BINARY(16)")
    private UUID code;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "auditoriumFunctionLayout")
    private Function function;

    @OneToMany(mappedBy = "auditoriumFunctionLayout")
    private List<Section> sections;

    @Column(name = "auditorium_code")
    private UUID auditoriumCode;

}

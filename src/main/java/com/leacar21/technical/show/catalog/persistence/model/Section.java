package com.leacar21.technical.show.catalog.persistence.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "section")
public class Section extends AbstractEntityJPA {

    @Column(name = "code", columnDefinition = "BINARY(16)")
    private UUID code;

    @Column(name = "name")
    private String name;

    @Column(name = "seat_price")
    private BigDecimal seatPrice;

    @ManyToOne(optional = false)
    @JoinColumn(name = "auditorium_function_layout_id", nullable = false)
    private AuditoriumFunctionLayout auditoriumFunctionLayout;

    @OneToMany(mappedBy = "section")
    private List<SectionSeat> sectionSeat;

}

package com.kodilla.hibernate.triggerTestEntitty;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "nowa_tablea")
public class TriggerEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    @NotNull
    private int id;

    @Column(name = "create_data_time")
    private String timestemp = String.valueOf(LocalDate.now());

    @Column(name = "kind_of_items")
    private String things;

    @Column(name = "number_of_utiems")
    private Integer someNumebr;

    public TriggerEntity(String things, Integer someNumebr) {
        this.things = things;
        this.someNumebr = someNumebr;
    }
}

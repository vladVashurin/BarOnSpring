package com.vld.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Alcohol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    private Long alcoholId;
    private String name;
    @OneToOne
    private AlcoholType alcoholType;

    public Alcohol(String name, AlcoholType alcoholType) {
        this.name = name;
        this.alcoholType = alcoholType;
    }
}

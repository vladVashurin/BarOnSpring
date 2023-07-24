package com.vld.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Bar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    private Long barId;
    private String name;
    private String address;
    @ManyToMany
    List<Alcohol> alcoholList;

    public Bar(String name, String address, List<Alcohol> alcoholList) {
        this.name = name;
        this.address = address;
        this.alcoholList = alcoholList;
    }
}

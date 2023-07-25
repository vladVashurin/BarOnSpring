package com.vld.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
    @ManyToMany(fetch = FetchType.EAGER)
    List<Alcohol> alcoholList;

    public Bar(String name, String address, List<Alcohol> alcoholList) {
        this.name = name;
        this.address = address;
        this.alcoholList = alcoholList;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return Objects.equals(barId, bar.barId) && Objects.equals(name, bar.name) &&
                Objects.equals(address, bar.address) && alcoholList.containsAll(bar.getAlcoholList()) && bar.getAlcoholList().containsAll(alcoholList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barId, name, address, alcoholList);
    }
}

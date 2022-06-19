package com.mber.study.javaee.husivm._06_jpa._091_one_to_one;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "091_address")
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String street;

    @OneToOne(mappedBy = "address")
    private Student student;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}

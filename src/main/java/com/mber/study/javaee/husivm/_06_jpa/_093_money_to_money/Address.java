package com.mber.study.javaee.husivm._06_jpa._093_money_to_money;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "093_address")
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String street;

    @ManyToMany(mappedBy = "addresses")  // not necessary
    private List<Student> student;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}

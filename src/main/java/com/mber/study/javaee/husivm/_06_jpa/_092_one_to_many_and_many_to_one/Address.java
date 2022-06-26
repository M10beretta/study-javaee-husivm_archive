package com.mber.study.javaee.husivm._06_jpa._092_one_to_many_and_many_to_one;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "092_address")
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String street;

//    @ManyToOne
//    private Student student;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}

package com.mber.study.javaee.husivm._06_jpa._091_one_to_one;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "091_student")
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;

    public Student(String name) {
        this.name = name;
    }
}



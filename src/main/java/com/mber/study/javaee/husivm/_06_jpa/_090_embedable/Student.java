package com.mber.study.javaee.husivm._06_jpa._090_embedable;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "090_student")
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Embedded
    private Address address;

    public Student(String name) {
        this.name = name;
        address = new Address("Minsk", "Pritytskogo");
    }
}


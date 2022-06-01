package com.mber.study.javaee.husivm._072_JPA._079_GeneratedValue;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity (name = "079D_student")
@NoArgsConstructor
public class StudentD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public StudentD(String name) {
        this.name = name;
    }
}

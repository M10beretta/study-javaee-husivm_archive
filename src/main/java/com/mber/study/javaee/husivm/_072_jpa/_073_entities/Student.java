package com.mber.study.javaee.husivm._072_jpa._073_entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;


@Entity (name = "073_student")
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public Student(String name) {
        this.name = name;
    }
}

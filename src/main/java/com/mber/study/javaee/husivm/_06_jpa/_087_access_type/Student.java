package com.mber.study.javaee.husivm._06_jpa._087_access_type;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity(name = "087_student")
@NoArgsConstructor
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Access(AccessType.PROPERTY)
    public String getName() {
        return "Mr " + name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


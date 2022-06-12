package com.mber.study.javaee.husivm._06_jpa._086_enums;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity(name = "086_student")
@NoArgsConstructor
class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    public Student(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }
}


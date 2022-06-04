package com.mber.study.javaee.husivm._06_jpa._084_transeint;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;

@Entity(name = "084_student")
@NoArgsConstructor
class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Transient
    private String surname;
    private transient int age;
}

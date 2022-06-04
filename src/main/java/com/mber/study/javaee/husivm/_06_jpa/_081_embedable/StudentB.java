package com.mber.study.javaee.husivm._06_jpa._081_embedable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@IdClass(StudentBPK.class)
@Entity(name = "081B_student")
@NoArgsConstructor
public class StudentB {
    @Id
    private String name;
    @Id
    private String surname;
    private int age;

    public StudentB(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}

@EqualsAndHashCode
class StudentBPK implements Serializable {
    private String name;
    private String surname;
}
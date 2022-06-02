package com.mber.study.javaee.husivm._06_jpa._079_generated_value;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity (name = "079A_student")
@NoArgsConstructor
public class StudentA {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public StudentA(String name) {
        this.name = name;
    }
}

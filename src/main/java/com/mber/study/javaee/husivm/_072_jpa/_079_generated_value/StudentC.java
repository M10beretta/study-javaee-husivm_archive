package com.mber.study.javaee.husivm._072_jpa._079_generated_value;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@SequenceGenerator(name = "079C_mySequense",initialValue = 100, allocationSize = 10)
@Entity (name = "079C_student")
@NoArgsConstructor
public class StudentC {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;

    public StudentC(String name) {
        this.name = name;
    }
}

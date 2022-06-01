package com.mber.study.javaee.husivm._072_JPA._079_GeneratedValue;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity(name = "079B_student")
@NoArgsConstructor
public class StudentB {
    @Id
    @TableGenerator(name = "myGen", table = "079B_mySequense", initialValue = 100, allocationSize = 10, pkColumnName = "name", pkColumnValue = "value")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "myGen")
    private int id;
    private String name;

    public StudentB(String name) {
        this.name = name;
    }
}

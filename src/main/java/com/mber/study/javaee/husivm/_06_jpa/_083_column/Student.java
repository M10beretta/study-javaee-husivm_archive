package com.mber.study.javaee.husivm._06_jpa._083_column;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity(name = "083_student")
@NoArgsConstructor
class Student {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "my_name", length = 50, nullable = false/*, unique = true, insertable = false, updatable = false*/)
    private String name;
    @Column(columnDefinition = "varchar (100) not null")
    private String surname;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

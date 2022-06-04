package com.mber.study.javaee.husivm._06_jpa._082_basic;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity(name = "082_student")
@NoArgsConstructor
class Student {
    @Id
    @GeneratedValue
    private int id;
    @Basic(optional = false)
    private String name;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] img;

    public Student(String name) {
        this.name = name;
    }
}

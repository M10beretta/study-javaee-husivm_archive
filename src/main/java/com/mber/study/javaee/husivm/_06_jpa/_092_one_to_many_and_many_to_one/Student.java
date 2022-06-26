package com.mber.study.javaee.husivm._06_jpa._092_one_to_many_and_many_to_one;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "092_student")
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")          // colum student_id not fill
    @OneToMany(cascade = CascadeType.ALL)                             // address will unique
    @JoinColumn(name = "stud_id")                             //two tables,  columns will create in adress table
//    @JoinTable(name = "092_stud_adr",                       //three tables
//            joinColumns = @JoinColumn(name = "stud_id"),
//            inverseJoinColumns = @JoinColumn(name = "adr_id"))
    private List<Address> addresses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }
}



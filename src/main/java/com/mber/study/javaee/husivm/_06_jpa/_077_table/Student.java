package com.mber.study.javaee.husivm._06_jpa._077_table;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;


@Entity(name = "077_student")
@Table(name = "077_student")
@NoArgsConstructor
@SecondaryTables({@SecondaryTable(name = "077_contact"), @SecondaryTable(name = "077_address")})
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private LocalDate birthday;

    @Setter
    @Column(table = "077_address")
    private String country;
    @Setter
    @Column(table = "077_address")
    private String city;
    @Setter
    @Column(table = "077_contact")
    private String phone;

        public Student(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}

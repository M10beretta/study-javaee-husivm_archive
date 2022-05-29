package com.mber.study.javaee.husivm._072_JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;


@Entity
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private LocalDate birthday;


    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}

package com.mber.study.javaee.husivm._06_jpa._085_temporal;

import com.mber.study.javaee.husivm._06_jpa.Repository;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try (var repository = new Repository()) {
            repository.begin();
            var d = new Date();
            var c = Calendar.getInstance();
            repository.persist(new Student("Mike", d,c));
            repository.commit();
        }
    }
}






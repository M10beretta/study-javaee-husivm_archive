package com.mber.study.javaee.husivm._06_jpa._091_one_to_one;

import com.mber.study.javaee.husivm._06_jpa.Repository;

public class Main {
    public static void main(String[] args) {
        try (var repository = new Repository()) {
            repository.begin();
            var mike = new Student("Mike");
            var helen = new Student("Helen");
            var address = new Address("Minsk", "Pritytskogo");

            mike.setAddress(address);
            address.setStudent(mike);
            helen.setAddress(address);

            repository.persist(address); // remove if @OneToOne(cascade = CascadeType.PERSIST)
            repository.persist(mike);
            repository.persist(helen);
            repository.commit();
        }
    }
}

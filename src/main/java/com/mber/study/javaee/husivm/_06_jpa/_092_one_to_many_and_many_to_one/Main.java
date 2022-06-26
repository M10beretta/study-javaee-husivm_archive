package com.mber.study.javaee.husivm._06_jpa._092_one_to_many_and_many_to_one;

import com.mber.study.javaee.husivm._06_jpa.Repository;

public class Main {
    public static void main(String[] args) {
        try (var repository = new Repository()) {
            repository.begin();
            var mike = new Student("Mike");
            var helen = new Student("Helen");

            var pritytskogo = new Address("Minsk", "Pritytskogo");
            var nemiga = new Address("Minsk", "Nemiga");
            var zibitskaya = new Address("Minsk", "Zibitskaya");

            mike.getAddresses().add(pritytskogo);
            mike.getAddresses().add(nemiga);

            helen.getAddresses().add(zibitskaya);
//            helen.getAddresses().add(pritytskogo);   // only with ManyToMany

            repository.persist(mike);
            repository.persist(helen);
            repository.commit();
        }
    }
}

package com.mber.study.javaee.husivm._06_jpa._093_money_to_money;

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
            helen.getAddresses().add(pritytskogo);

            repository.persist(mike);
            repository.persist(helen);
            repository.commit();
        }
    }
}

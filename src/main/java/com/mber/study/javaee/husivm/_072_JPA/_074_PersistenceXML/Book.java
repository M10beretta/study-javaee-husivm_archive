package com.mber.study.javaee.husivm._072_JPA._074_PersistenceXML;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;


@Entity(name = "074_book")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    public Book(String title) {
        this.title = title;
    }
}

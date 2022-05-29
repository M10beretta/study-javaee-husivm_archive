package com.mber.study.javaee.husivm._072_JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @Setter
    private String title;

    public Book(String title) {
        this.title = title;
    }
}

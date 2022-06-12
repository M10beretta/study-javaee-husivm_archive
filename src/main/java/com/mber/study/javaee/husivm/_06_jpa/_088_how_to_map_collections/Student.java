package com.mber.study.javaee.husivm._06_jpa._088_how_to_map_collections;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.*;


@Entity(name = "088_student")
@NoArgsConstructor
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "088_list")
    @Column(name = "value")
    private List<String> list = new ArrayList<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "088_map")
    @Column(name = "value")
    @MapKeyColumn(name = "key")
    private Map<Integer, String> map = new HashMap<>();

    public Student(String name) {
        this.name = name;
        list.addAll(Arrays.asList("B", "A", "D", "C"));
        map.put(1, "B");
        map.put(2, "A");
        map.put(3, "D");
        map.put(4, "C");
    }
}

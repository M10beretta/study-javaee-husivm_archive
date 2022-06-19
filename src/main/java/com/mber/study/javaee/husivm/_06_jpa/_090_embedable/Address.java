package com.mber.study.javaee.husivm._06_jpa._090_embedable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
class Address {
    private String city;
    private String street;
}

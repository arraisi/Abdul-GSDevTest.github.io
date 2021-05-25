package com.geekseat.abdul.technical.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
    private Integer age;
    private Integer deathOnYear;

    public Person() {
        this.age = 0;
        this.deathOnYear = 0;
    }

    public Integer bornOnYear() {
        return deathOnYear - age;
    }
}

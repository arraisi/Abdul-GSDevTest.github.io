package com.geekseat.abdul.technical.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private Integer age;
    private Integer deathOnYear;

    public Integer bornOnYear() {
        return (age == null || deathOnYear == null) ? -1 : (deathOnYear - age);
    }
}

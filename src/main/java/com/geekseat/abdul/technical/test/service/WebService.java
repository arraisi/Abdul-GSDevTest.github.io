package com.geekseat.abdul.technical.test.service;

import com.geekseat.abdul.technical.test.model.Person;
import org.springframework.stereotype.Service;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;

@Service
public class WebService {

    public double calculateAverageNumberKilled(ArrayList<Person> persons) {
        try {
            dataValidation(persons);
            return persons.stream().mapToDouble(person -> totalKilledInYear(person.bornOnYear())).sum() / persons.size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public boolean dataValidation(ArrayList<Person> persons) throws IllegalArgumentException {
        if (persons.size() < 2) {
            throw new IllegalArgumentException("Data must be more than one");
        }

        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getAge() == null || persons.get(i).getDeathOnYear() == null
                    || persons.get(i).getAge() < 0 || persons.get(i).bornOnYear() < 0) {
                throw new IllegalArgumentException("Invalid data");
            }
        }

        return true;
    }

    public int totalKilledInYear(int numberOfYear) {

        int n1 = 1, n2 = 1, n3, i, totalKilled = 2;

        if (numberOfYear <= 2) {
            return numberOfYear;
        }

        for (i = 2; i < numberOfYear; ++i) // loop starts from 2 because 0 and 1 are already initialized
        {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            totalKilled += n3;
        }

        return totalKilled;
    }
}

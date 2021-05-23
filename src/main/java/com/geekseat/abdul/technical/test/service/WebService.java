package com.geekseat.abdul.technical.test.service;

import com.geekseat.abdul.technical.test.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WebService {

    public double calculateAverageNumberKilled(ArrayList<Person> persons) {
        try {

            if (dataValidation(persons)) {
                return persons.stream().mapToDouble(person -> totalKilledInYear(person.bornOnYear())).sum() / persons.size();
            } else return -1;

        } catch (Exception e) {
            return -1;
        }
    }

    public boolean dataValidation(ArrayList<Person> persons) {
        if (persons.size() < 2) {
            return false;
        }

        for (int i = 0; i < persons.size() - 1; i++) {
            if (persons.get(i).getAge() == null || persons.get(i).getDeathOnYear() == null || persons.get(i).bornOnYear() < 1) {
                return false;
            }
        }

        return true;
    }

    public int totalKilledInYear(int numberOfYear) {

        int n1 = 1, n2 = 1, n3, i, totalKilled = 2;
//        System.out.print(n1 + " " + n2); // printing 1 and 2

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

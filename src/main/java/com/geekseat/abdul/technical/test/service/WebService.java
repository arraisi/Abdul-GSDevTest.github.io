package com.geekseat.abdul.technical.test.service;

import com.geekseat.abdul.technical.test.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WebService {
    public double solution(ArrayList<Person> persons) {
        try {
            return persons.stream().mapToDouble(person -> totalKilledOnYear(person.bornOnYear())).sum() / persons.size();
        } catch (Exception e) {
            return -1;
        }
    }

    public int totalKilledOnYear(int numberOfYear) {

        int n1 = 1, n2 = 1, n3, i, killed = 2;
//        System.out.print(n1 + " " + n2); // printing 1 and 2

        if (numberOfYear <= 2) {
            return numberOfYear;
        }

        for (i = 2; i < numberOfYear; ++i) // loop starts from 2 because 0 and 1 are already initialized
        {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            killed += n3;
        }

        return killed;
    }
}

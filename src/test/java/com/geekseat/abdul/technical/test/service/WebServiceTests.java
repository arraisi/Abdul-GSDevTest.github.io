package com.geekseat.abdul.technical.test.service;

import com.geekseat.abdul.technical.test.model.Person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class WebServiceTests {

    private final WebService service = new WebService();

    @Test
    @DisplayName("Test menghitung rata-rata orang terbunuh benar")
    public void testCalculateAverageNumberKilledSuccess() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(10, 12));
        persons.add(new Person(13, 17));
        double averageNumberKilled = service.calculateAverageNumberKilled(persons);
        assertEquals(4.5, averageNumberKilled);
    }

    @Test
    @DisplayName("Test menghitung rata-rata orang terbunuh salah")
    public void testCalculateAverageNumberKilledFailed() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(10, 12));
        persons.add(new Person(13, 17));
        double averageNumberKilled = service.calculateAverageNumberKilled(persons);
        assertNotEquals(0, averageNumberKilled);
    }

    @Test
    @DisplayName("Test untuk validasi data valid")
    public void testDataValidationSuccess() throws IllegalAccessException {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(10, 12));
        persons.add(new Person(13, 17));
        assertTrue(service.dataValidation(persons));
    }

    @Test
    @DisplayName("Test untuk validasi data invalid")
    public void testDataValidationFailed() throws IllegalAccessException {

        ArrayList<Person> persons1 = new ArrayList<>();
        persons1.add(new Person(null, 12));
        assertThrows(IllegalArgumentException.class, () -> {
            service.dataValidation(persons1);
        });

        ArrayList<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(10, null));
        assertThrows(IllegalArgumentException.class, () -> {
            service.dataValidation(persons2);
        });

        ArrayList<Person> persons3 = new ArrayList<>();
        persons3.add(new Person(10, 5));
        assertThrows(IllegalArgumentException.class, () -> {
            assertFalse(service.dataValidation(persons3));
        });
    }

    @Test
    @DisplayName("Test untuk menghitung yang terbunuh berdasarkan tahun benar")
    public void testTotalKilledInYearSuccess() {
        double numberKilledIn2th = service.totalKilledInYear(2);
        assertEquals(2, numberKilledIn2th);

        double numberKilledIn4th = service.totalKilledInYear(4);
        assertEquals(7, numberKilledIn4th);

        double numberKilledIn5th = service.totalKilledInYear(5);
        assertEquals(12, numberKilledIn5th);
    }

    @Test
    @DisplayName("Test untuk menghitung total yang terbunuh berdasarkan tahun salah")
    public void testTotalKilledInYearFailed() {
        double numberKilledIn2th = service.totalKilledInYear(2);
        assertNotEquals(1, numberKilledIn2th);
        assertNotEquals(3, numberKilledIn2th);

        double numberKilledIn4th = service.totalKilledInYear(4);
        assertNotEquals(4, numberKilledIn4th);
    }
}

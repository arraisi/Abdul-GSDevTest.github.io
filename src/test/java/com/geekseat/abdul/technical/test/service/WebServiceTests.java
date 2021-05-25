package com.geekseat.abdul.technical.test.service;

import com.geekseat.abdul.technical.test.model.Person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class WebServiceTests {

    private final WebService service = new WebService();

    @Test
    @DisplayName("Test berhasil menghitung rata-rata orang terbunuh")
    public void testCalculateAverageNumberKilledSuccess() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(10, 12));
        persons.add(new Person(13, 17));
        double averageNumberKilled = service.calculateAverageNumberKilled(persons);
        assertEquals(4.5, averageNumberKilled);

        ArrayList<Person> persons2nd = new ArrayList<>();
        persons2nd.add(new Person(10, 10));
        persons2nd.add(new Person(13, 13));
        double averageNumberKilled2nd = service.calculateAverageNumberKilled(persons2nd);
        assertEquals(0, averageNumberKilled2nd);
    }

    @Test
    @DisplayName("Test gagal menghitung rata-rata orang terbunuh")
    public void testCalculateAverageNumberKilledFailed() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(10, 12));
        persons.add(new Person(13, 17));
        double averageNumberKilled = service.calculateAverageNumberKilled(persons);
        assertNotEquals(0, averageNumberKilled);
    }

    @Test
    @DisplayName("Test valid, validasi data")
    public void testDataValidationSuccess() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(10, 12));
        persons.add(new Person(13, 17));
        assertTrue(service.dataValidation(persons));

        ArrayList<Person> persons2nd = new ArrayList<>();
        persons2nd.add(new Person(10, 10));
        persons2nd.add(new Person(13, 13));
        assertTrue(service.dataValidation(persons2nd));
    }

    @Test
    @DisplayName("Test invalid, validasi data")
    public void testDataValidationFailed() {

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
    @DisplayName("Test berhasil menghitung yang terbunuh berdasarkan tahun")
    public void testTotalKilledInYearSuccess() {
        double numberKilledIn1st = service.totalKilledInYear(1);
        assertEquals(1, numberKilledIn1st);

        double numberKilledIn2nd = service.totalKilledInYear(2);
        assertEquals(2, numberKilledIn2nd);

        double numberKilledIn3th = service.totalKilledInYear(3);
        assertEquals(4, numberKilledIn3th);

        double numberKilledIn4th = service.totalKilledInYear(4);
        assertEquals(7, numberKilledIn4th);

        double numberKilledIn5th = service.totalKilledInYear(5);
        assertEquals(12, numberKilledIn5th);
    }

    @Test
    @DisplayName("Test gagal menghitung total yang terbunuh berdasarkan tahun")
    public void testTotalKilledInYearFailed() {
        double numberKilledIn2nd = service.totalKilledInYear(2);
        assertNotEquals(1, numberKilledIn2nd);
        assertNotEquals(3, numberKilledIn2nd);

        double numberKilledIn4th = service.totalKilledInYear(4);
        assertNotEquals(4, numberKilledIn4th);
    }
}

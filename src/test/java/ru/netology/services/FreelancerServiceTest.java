package ru.netology.services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class FreelancerServiceTest {

    @Test
    public void calculateTest1(){
        FreelancerService service = new FreelancerService();
        int income = 10_000;
        int expenses = 3_000;
        int threshold = 20_000;

        int actual = service.calculate (income, expenses,threshold);
        int expected = 3;

        Assertions.assertEquals (expected, actual);
    }

    @Test
    public void calculateTest2(){
        FreelancerService service = new FreelancerService();
        int income = 100_000;
        int expenses = 60_000;
        int threshold = 150_000;

        int actual = service.calculate (income, expenses,threshold);
        int expected = 2;

        Assertions.assertEquals (expected, actual);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "test_data.csv")

    public void testCalculateWithParams (int income, int expenses, int threshold, int expected) {
        FreelancerService service = new FreelancerService();

        int actual = service.calculate(income, expenses, threshold);

        Assertions.assertEquals (expected, actual);
    }
}
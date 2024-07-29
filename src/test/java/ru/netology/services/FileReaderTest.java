package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Employee;

import java.util.ArrayList;
import java.util.List;

class FileReaderTest {

    @Test
    void parseEmptyXMLTest() {
        List<Employee> expectedResult = new ArrayList<>();
        String filename = "src/test/resources/data_test_empty.xml";

        List<Employee> actualResult = FileReader.parseXML(filename);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void parseEmptyCSVTest() {
        List<Employee> expectedResult = new ArrayList<>();
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String filename = "src/test/resources/data_test_empty.csv";

        List<Employee> actualResult = FileReader.parseCSV(columnMapping, filename);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
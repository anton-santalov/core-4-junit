package ru.netology.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Employee;
import ru.netology.services.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class UtilsTest {

    @Test
    void emptyListToJsonTest() {
        String expectedResult = "[]";
        List<Employee> employees = new ArrayList<>();

        String actualResult = Utils.listToJson(employees);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void parseXMLToJsonTest() throws IOException {
        Path path = Path.of("src/test/resources/data_test_two_employees.txt");
        String expectedString = Files.readString(path);
        String expectedResult = expectedString.replaceAll("\n", "").replaceAll("\r", "");

        String filename = "src/test/resources/data_test_two_employees.xml";
        List<Employee> employees = FileReader.parseXML(filename);
        String actualString = Utils.listToJson(employees);
        String actualResult = actualString.replaceAll("\n", "").replaceAll("\r", "");

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void parseCSVToJsonTest() throws IOException {
        Path path = Path.of("src/test/resources/data_test_two_employees.txt");
        String expectedString = Files.readString(path);
        String expectedResult = expectedString.replaceAll("\n", "").replaceAll("\r", "");

        String filename = "src/test/resources/data_test_two_employees.csv";
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        List<Employee> employees = FileReader.parseCSV(columnMapping, filename);
        String actualString = Utils.listToJson(employees);
        String actualResult = actualString.replaceAll("\n", "").replaceAll("\r", "");

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
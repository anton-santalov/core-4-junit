package ru.netology;

import ru.netology.utils.Utils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String csvFileName = "data.csv";
        String xmlFileName = "data.xml";

        // CSV to JSON
        List<Employee> csvList = ru.netology.services.FileReader.parseCSV(columnMapping, csvFileName);
        String csvJson = Utils.listToJson(csvList);
        ru.netology.services.FileWriter.writeString(csvJson, "data.json");

        // XML to JSON
        List<Employee> xmlList = ru.netology.services.FileReader.parseXML(xmlFileName);
        String xmlJson = Utils.listToJson(xmlList);
        ru.netology.services.FileWriter.writeString(xmlJson, "data2.json");
    }
}
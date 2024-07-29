package ru.netology.services;

import java.io.IOException;

public class FileWriter {
    public static void writeString(String json, String fileName) {
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

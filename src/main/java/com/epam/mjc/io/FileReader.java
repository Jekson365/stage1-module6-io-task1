package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = null;
        int age = 0;
        String email = null;
        long phone = 0;

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    switch (key) {
                        case "Name":
                            name = value;
                            break;
                        case "Age":
                            age = Integer.parseInt(value);
                            break;
                        case "Email":
                            email = value;
                            break;
                        case "Phone":
                            phone = Long.parseLong(value);
                            break;
                        default:
                            // Ignore unknown keys
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(name, age, email, phone);
    }
}
package com.example.labo1.Service;

import com.example.labo1.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class PersonService {
    public static void readCsvFile() throws Exception{
        String filePath = "./Data/people.csv";
        try( CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                for (String value : line) {
                    value.split(",");
                    System.out.print(value );
                }
                System.out.println();
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println(e.getMessage());
        }
    }





    public static void main(String[] args) throws Exception {
        readCsvFile();
    }

}

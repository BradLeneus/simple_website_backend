package com.example.labo1.Service;

import com.example.labo1.Model.Person;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    public static List<Person> readDataLineByLine(String file)
    {

        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            List<Person> allPerson = new ArrayList<>();
            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                List<String> listString = new ArrayList<>();
                for (String cell : nextRecord) {

                    listString.add(cell);

                }

                Person person = new Person();
                person.setId(Integer.parseInt(listString.get(0)));
                person.setName(listString.get(1));
                person.setLastName(listString.get(2));
                person.setEmail(listString.get(3));
                person.setGender(listString.get(4));
                allPerson.add(person);
            }

            return allPerson;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

         List<Person> list =  readDataLineByLine("./data/person.csv");
        System.out.println(list.get(0));
    }
}

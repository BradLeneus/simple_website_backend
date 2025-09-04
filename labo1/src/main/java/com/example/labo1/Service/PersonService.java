package com.example.labo1.Service;

import com.example.labo1.Model.Person;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {
    public List<Person> listPerson = readDataLineByLine();
    public List<Person> readDataLineByLine()
    {

        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader("./data/person.csv");

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

   public List<Person> filterByName(String name){
        List<Person> tempList = new ArrayList<>();
        List<Person> allPerson = readDataLineByLine();
        for(Person person: allPerson){
            if (person.getName().toLowerCase().equals(name.toLowerCase())){
                tempList.add(person);
            }
        }
        if(!tempList.isEmpty()){

            return tempList;
        }
        else {
            return null;
        }
   }


}

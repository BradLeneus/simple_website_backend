package com.example.labo1.Service;

import com.example.labo1.Model.Person;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {
    private final List list;
    public List<Person> listPerson = readDataLineByLine();

    public PersonService(List list) {
        this.list = list;
    }

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
    public Person filterById(int id){

        List<Person> allPerson = readDataLineByLine();
        for(Person person: allPerson){
            if (person.getId() == id){
                return person;
            }
        }


        return null;
    }
    public void listToCsvFile(List<Person> listToWrite) {
        String filePath = "./data/personTest.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write header (optional but recommended)



            // Write data rows
            for (Person data : listToWrite) {
                writer.write(data.getId() + "," + data.getName() + "," + data.getLastName() + "," + data.getEmail() + "," + data.getGender());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteById(int id){
        try{
            List<Person> tempList = listPerson;
            int index = 0;
            for(Person p: tempList){
                if(p.getId() == id){
                    tempList.remove(index);

                    listToCsvFile(tempList);
                    return true;
                }
                index++;
            }

            return false;
        }
        catch (Exception e){
            e.getMessage();
        }



        return false;
    }
    public int getTheBiggestIdPlus1(){
       int biggestId = 0;
       for(Person person : listPerson){
           if (person.getId() >biggestId){
               biggestId = person.getId();
           }

       }

       return biggestId + 1;
    }
    public boolean createOnePerson(Person person){
        listPerson.add(person);
        listToCsvFile(listPerson);
        return true;

    }

}

package com.homeWork;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectMapper_HW_48 {

    public static ObjectMapper oMapper = new ObjectMapper();

    public static void main(String [] args) throws IOException {

        File file = new File("persons.json");

        List<Person> list = new ArrayList<>();
        list.add(new Person(111111, 21, "Tom B"));
        list.add(new Person(222222, 50, "Anna V"));
        list.add(new Person(333333, 34, "Daniel A"));

        oMapper.writeValue(file, list);

        List<Person> persons = readFromFile(file);

        persons.forEach(System.out::println);

    }

    private static List<Person> readFromFile(File file) throws IOException {

        String json = null;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            json = br.readLine();
        }

        return oMapper.readValue(json, new TypeReference<List<Person>>(){});
    }

    public static class Person {

        int id;
        int age;
        String name;

        public Person() {
        }

        public Person(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}

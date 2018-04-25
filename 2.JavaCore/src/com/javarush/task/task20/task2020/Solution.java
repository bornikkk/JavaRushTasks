package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream outputStream = new FileOutputStream("c:\\your.file");
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        Person person = new Person("Boris", "Nik", "Russlan", Sex.MALE);
        oos.writeObject(person);

        FileInputStream inputStream = new FileInputStream("c:\\your.file");
        ObjectInputStream fis = new ObjectInputStream(inputStream);

        Person person1 = (Person) fis.readObject();
        System.out.println(person1.firstName + person1.lastName);
    }
}

package com.example.SpringDockerAssignment.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "Candidate")
public class Candidate implements Serializable {

    @Id
    private Integer id;
    private int age;
    private String name;
    private String gender;
    private String city;
    private String dob;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Candidate(int id, int age, String name, String gender, String city, String dob) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.city = city;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return " {\n" +
                "        \"id\": "+id+",\n" +
                "        \"age\": "+age+",\n" +
                "        \"name\": "+name+",\n" +
                "        \"gender\": "+gender+",\n" +
                "        \"city\": "+city+",\n" +
                "        \"dob\": "+dob+"\n" +
                "    " +
                "}";
    }
}

package com.company;

import java.util.ArrayList;
import java.util.List;

public class Data2 implements ISaveable{
    private String name;
    private String universityName;
    private int age;

    @Override
    public List<String> write() {
        List<String> write = new ArrayList<>();
        write.add(this.name);
        write.add(this.universityName);
        write.add("" + this.age);
        return write;
    }

    @Override
    public void read(List<String> savedValues) {
        this.name = savedValues.get(0);
        this.universityName = savedValues.get(1);
        this.age = Integer.parseInt(savedValues.get(2));
    }

    @Override
    public String toString() {
        return "Data2{" +
                "name = '" + name + '\'' +
                ", universityName = '" + universityName + '\'' +
                ", age = " + age +
                '}';
    }

    public Data2(String name, String universityName, int age) {
        this.name = name;
        this.universityName = universityName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Data1 implements ISaveable {
    private String name;
    private String schoolName;
    private int hotnessLevel;
    private int wholesomeLevel;

    @Override
    public String toString() {
        return "Data1{" +
                "name = '" + name + '\'' +
                ", schoolName = '" + schoolName + '\'' +
                ", hotnessLevel = " + hotnessLevel +
                ", wholesomeLevel = " + wholesomeLevel +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getHotnessLevel() {
        return hotnessLevel;
    }

    public void setHotnessLevel(int hotnessLevel) {
        this.hotnessLevel = hotnessLevel;
    }

    public int getWholesomeLevel() {
        return wholesomeLevel;
    }

    public void setWholesomeLevel(int wholesomeLevel) {
        this.wholesomeLevel = wholesomeLevel;
    }

    public Data1(String name, String schoolName, int hotnessLevel, int wholesomeLevel) {
        this.name = name;
        this.schoolName = schoolName;
        this.hotnessLevel = hotnessLevel;
        this.wholesomeLevel = wholesomeLevel;
    }
    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(this.name);
        values.add(this.schoolName);
        //"" + intVar turns the variable into a String
        values.add("" + this.hotnessLevel);
        values.add("" + this.wholesomeLevel);

        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if(!savedValues.equals(null) && (savedValues.size() > 0)){
            this.name = savedValues.get(0);
            this.schoolName = savedValues.get(1);
            this.hotnessLevel = Integer.parseInt(savedValues.get(2));
            this.wholesomeLevel = Integer.parseInt(savedValues.get(3));
        }
    }
}

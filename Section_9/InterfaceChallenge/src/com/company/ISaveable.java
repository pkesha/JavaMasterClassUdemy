package com.company;

import java.util.ArrayList;

public interface ISaveable {
    //Update
    ArrayList<String> write = new ArrayList<String>();
    void read(ArrayList<String> savedValues);



}

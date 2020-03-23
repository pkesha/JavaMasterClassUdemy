package com.company;

import java.util.ArrayList;
import java.util.List;

public interface ISaveable {
    //2 functions.  One returns an arrayList<String>
    //Another is of type
    List<String> write();
    void read(List<String> savedValues);
}

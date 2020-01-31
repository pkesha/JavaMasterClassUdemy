package com.timbuchalka;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 30/09/15.
 */
public interface ISaveable {
    //ArrayList<String> write();
    //void read(ArrayList<String> savedValues);
    //this makes it abstract:
    List<String> write();
    //Extra flexibility - and more abstract by letting the user implement whatever type
    //of list they need
    void read(List savedValues);

}

package com.company;

import java.util.ArrayList;

public class Contacts {
    private String contactNames;
    private String contactNumbers;

    public Contacts(String contactNames, String contactNumbers) {
        this.contactNames = contactNames;
        this.contactNumbers = contactNumbers;
    }

    public String getContactNames() {
        return contactNames;
    }

    public String getContactNumbers() {
        return contactNumbers;
    }

    public static Contacts createContact(String name, String phoneNumber){
        return new Contacts(name, phoneNumber);
    }
}

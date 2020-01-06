package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class MobilePhone {
    String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    public boolean addNewContact(Contacts contacts){
        if(findContact(contacts.getContactNames()) >= 0){
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contacts);
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getContactNames() + " was not found.");
            return false;
        } else if (findContacts(newContact.getContactNames()) != -1){
            System.out.println("Contact with name " + newContact.getContactNames() +
                    " already exists. Update was not successful");
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getContactNames() + ", was replaced with " +
                newContact.getContactNames());
        return true;
    }

    private int findContact(Contacts contacts){
        return this.myContacts.indexOf(contacts);
    }

    private int findContact(String contactName){
        for (int i = 0; i < this.myContacts.size(); i++){
            Contacts contacts = this.myContacts.get(i);
            if (contacts.getContactNames().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public boolean removeContact(Contacts contacts){
        int foundPosition = findContact(contacts);
        if(foundPosition < 0){
            System.out.println(contacts.getContactNames() + " was not found.");
            return false;
        }

        this.myContacts.remove(contacts);
        System.out.println(contacts.getContactNames() + "was removed");
        return true;
    }

    private int findContacts(int contacts){
        return this.myContacts.indexOf(contacts);
    }

    private int findContacts(String contacts){
        return this.myContacts.indexOf(contacts);
    }

    public String queryContact (Contacts contacts){
        if (findContact(contacts) >= 0) {
            return contacts.getContactNames();
        }
        return null;
    }

    public Contacts queryContact(String name){
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts(){
    System.out.println("Contact list: ");
        for(int i = 0; i < this.myContacts.size(); i++){
            System.out.println("Contact " + (i+1) + ": " +
                    this.myContacts.get(i).getContactNames() +
                    " and number: "
                    + this.myContacts.get(i).getContactNumbers());
        }
    }
}


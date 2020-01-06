package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone =
            new MobilePhone("2244067771");

    public static void main(String[] args) {
        System.out.println("Option 1: Quit");
        System.out.println("Option 2: Add contact");
        System.out.println("Option 3: Update contact");
        System.out.println("Option 4: Remove contact");
        System.out.println("Option 5: Search contact");
        System.out.println("Option 6: List contacts");

        getOptions();
    }

    public static void getOptions() {
        System.out.println("Please enter your option: ");
        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1:
                Runtime.getRuntime().exit(0);
            case 2:
                addNewContact();
                getOptions();
            case 3:
                System.out.println("Enter contact needed for update: ");
                updateContactNow();
                getOptions();
            case 4:
                System.out.println("Enter contact for removal: ");
                String removeContact = scanner.nextLine();
                removeContactNow();
                getOptions();
            case 5:
                System.out.println("Enter contact for search: ");
                String searchContact = scanner.nextLine();
                searchContactNow();
                getOptions();
            case 6:
                mobilePhone.printContacts();
                getOptions();
        }
    }

    private static void addNewContact() {
        System.out.println("Enter number:");
        String newContactNumber = scanner.nextLine();

        System.out.println("Enter name:");
        String newContactName = scanner.nextLine();

        Contacts contactsNew = Contacts.createContact(newContactName, newContactNumber);
        //addNewContact already checks for whether it exists and then adds it
        if (mobilePhone.addNewContact(contactsNew)) {
            System.out.println("New contact added: " + newContactName + ", Phone = " +
                    newContactNumber);
        } else {
            System.out.println("Cannot add, name is on file");
        }
    }

    public static void updateContactNow() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);

        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record.");
        }
    }

    public static void searchContactNow() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);

        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getContactNames() +
                " phone number is " +
                existingContactRecord.getContactNumbers());
    }

    public static void removeContactNow() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);

        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        if (mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    public static void queryContactNow() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);

        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getContactNames() +
                " phone number is " + existingContactRecord.getContactNumbers());
    }
}

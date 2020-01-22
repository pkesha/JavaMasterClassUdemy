package com.company;

public class Main {

    public static void main(String[] args) {
        iTelephone parhamPhone;
        parhamPhone = new DeskPhone(12345);
        parhamPhone.powerOn();
        parhamPhone.callPhone(12345);
        parhamPhone.answer();

        parhamPhone = new MobilePhone(1111110);
        parhamPhone.powerOn();
        parhamPhone.callPhone(1111110);
        parhamPhone.answer();
    }
}

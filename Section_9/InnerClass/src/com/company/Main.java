package com.company;

//import jdk.vm.ci.meta.Local;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {

        //Anonymous methods
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
        listen();
        /*Local Class:
        class ClickListener implements Button.OnClickListener{
            public ClickListener() {
                System.out.println("I've been attached");
            }

            @Override
            public void onClick(String title){
                System.out.println(title + " was clicked");
            }
        }

        btnPrint.setOnClickListener(new ClickListener());
        listen();*/

        /*Gearbox mcLaren = new Gearbox(6);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));*/

        /*//Creating new instance of gear with instance of mcLaren Gearbox
        Gearbox.Gear first = mcLaren.new Gear(1, 12.3);


        //These don't work:
        //Gearbox.Gear second = new Gearbox.Gear(2, 15.4);
        //Gearbox.Gear third = new mcLaren.Gear(3, 17.8);


        System.out.println(first.driveSpeed(1000));
        */

        /*
    }*/
    }

    private static void listen(){
        boolean quit = false;
        while(!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }
    }
}

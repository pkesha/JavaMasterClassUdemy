package com.keshavarziparham;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Ideally, Theater.Seat to find min or max would be done within theater class.
        //Seat class is public
        Theater theater = new Theater("Olympian", 8, 12);


        //Seat instances are shared but the lists of the seats
        //are two different instances
        if(theater.reserveSeat("D12")){
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already reserved");
        }

        if(theater.reserveSeat("B13")){
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Seat already reserved");
        }

        if(theater.reserveSeat("D12")){
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already reserved");
        }

        //Starts to highest object and goes down
        List<Theater.Seat> reverseSeats = new ArrayList<>(theater.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theater.Seat> priceSeats = new ArrayList<>(theater.getSeats());
        priceSeats.add(theater.new Seat("B00", 13.00));
        priceSeats.add(theater.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theater.PRICE_ORDER);
        printList(reverseSeats);

/*      This was also marked for deletion by the instructor

        List<Theater.Seat> seatCopy = new ArrayList<>(theater.seats);
        printList(seatCopy);
        seatCopy.get(1).reserve();

        //This will prove that they are different lists
        Collections.shuffle(seatCopy);
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.seat");
        printList(theater.seats);

        Theater.Seat minSeat = Collections.min(seatCopy);
        Theater.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        //Sorts
        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);

        //Common mistake
        List<Theater.Seat> newList = new ArrayList<>(theater.seats.size());
        Collections.copy(newList, theater.seats);

        Theater theater = new Theater("Star Wars", 8 , 12);
        //theater.getSeats();

        if( theater.reserveSeat("H11")){
            System.out.println("Please pay");
        } else{
            System.out.println("Sorry, seat is taken");
        }

        if( theater.reserveSeat("H11")){
            System.out.println("Please pay");
        } else{
            System.out.println("Sorry, seat is taken");
        }*/
    }

    public static void printList(List<Theater.Seat> list){
        for(Theater.Seat seat : list){
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("========================================");
    }

    //Instructor deleted this code
    /*public static void sortList(List<? extends Theater.Seat> list){
        for (int i = 0; i < (list.size() - 1); i++){
            for (int j = i + 1; j < list.size(); j++){
                if(list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list, i , j);
                }
            }
        }
    }*/
}

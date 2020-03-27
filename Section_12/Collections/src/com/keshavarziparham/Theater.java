package com.keshavarziparham;

import java.util.*;

public class Theater {
    private final String theaterName;
    private List<Seat> seats = new LinkedList<>();

    static final Comparator<Seat> PRICE_ORDER;

    static {
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat Seat1, Seat Seat2) {
                if (Seat1.getPrice() < Seat2.getPrice()) return -1;
                else if (Seat1.getPrice() > Seat2.getPrice()) return 1;
                else return 0;
            }
        };
    }

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;

        int lastRow = 'A' + (numRows - 1);
        for(char row = 'A'; row <= lastRow; row++){
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                double price = 12.00;

                if((row < 'D') && (seatNum >= 4 && seatNum <= 9)) price = 14.00;
                else if ((row > 'F') || ((seatNum < 4) || (seatNum > 9))) price = 7.00;

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                this.seats.add(seat);
            }
        }
    }

    public String getTheaterName() {
        return theaterName;
    }

    public boolean reserveSeat (String seatNumber){
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0){
            return this.seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

//        for (Seat seat : seats){
//            System.out.println(".");
//            if (seat.getSeatNumber().equals(seatNumber)){
//                requestedSeat = seat;
//            }
//        }
//
//        if (requestedSeat == null){
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//
//        return requestedSeat.reserve();
    }

    public Collection<Seat> getSeats() {
        return this.seats;
    }

    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;
        private double price;

        public Seat(String seatNumber, double price){
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public double getPrice() {
            return this.price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + this.seatNumber + " reserved");
                return true;
            } else{
                return false;
            }
        }

        public boolean cancel(){
            if (this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat " + this.seatNumber +
                        " cancelled");
                return true;
            } else{
                return false;
            }
        }

        public String getSeatNumber(){
            return this.seatNumber;
        }
    }
}

public class BarkingDog {
    public static boolean shouldWakeUp (boolean barking, int hourOfDay){
        if (barking && ((hourOfDay > 22) || (hourOfDay < 8)) && (!((hourOfDay>23) ||
                (hourOfDay < 0))) ) {
            return true;
        } else {
            return false;
        }
        //Return false if the hours are less than zero or greater than 24
    }
}

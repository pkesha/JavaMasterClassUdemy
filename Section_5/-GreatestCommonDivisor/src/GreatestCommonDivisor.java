public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor (int first, int second) {
        //Error check: Both values have to be bigger than 10
        if ((first < 10) || (second < 10)) {
            return -1;
        }

        //Initialize counters - they are also used for divisors
        int count1 = 0;
        int count2 = 0;
        int GCD = 0;

        //Checking for GCD
        while (count1 != first) {
            count1++;
            //if there is a remainder, then skip code and check for divisor without one
            if ((first % count1) == 0) {
                while (count2 != second) {
                    count2++;
                    //Check if number is divisible by count2 and equal to count1.
                    //Also check if current GCD is smaller than the count2
                    GCD = ((second % count2 == 0) && (count2 == count1) &&
                            (GCD < count2)) ? count2 : GCD;
                }
                count2 = 0;
            }
        }
        return GCD;
    }
}

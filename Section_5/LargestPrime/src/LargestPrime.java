public class LargestPrime {
    public static int getLargestPrime(int number){
        if (((number) <= 1)){
            //Return -1 if it is not a prime number (divisible by 2) or negative
            return -1;
        } else if (number/2 == 1){
            return 2;
        } else if (number > 2) {
            int i;
            for (i = number/2 ; i > 1; i--) {
                //Set number to the highest divisible number -
                //Dividing by the smallest numbers first will get you the largest value
                number = ((number % i) == 0) ? i : number;
            }
            //if i is greater than one, return the value.
            return number;
        }
        return -1;
    }
}

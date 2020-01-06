public class PerfectNumber {
    public static boolean isPerfectNumber (int number){
        int sum = 0;
        for (int i = 1; i < number; i++){
            sum += (number % i == 0) ? i : 0;
        }

        return ((sum == number) && (number > 0)) ? true : false;
    }
}

public class EvenDigitSum {
    public static int getEvenDigitSum (int number){
        if (number < 0){
            return -1;
        }

        int evenSum = 0;

        while (number > 0){
            evenSum += (number % 2 == 0) ? (number % 10) : 0;
            number /= 10;
        }

        return evenSum;
    }
}

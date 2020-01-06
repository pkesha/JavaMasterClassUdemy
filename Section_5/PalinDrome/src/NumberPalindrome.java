public class NumberPalindrome {
    public static boolean isPalindrome(int number){
        int n = number;
        int reverse = 0, count = 0;
        int digit;

        while (n != 0){
            n /= 10;
            count++;
        }

        n = number;
        while(n != 0){
            count--;
            digit = n % 10;
            reverse += digit * (int)(Math.pow(10, count));
            n /= 10;
        }
        return (reverse == number) ? true : false;
    }
}

import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);
        int temp = 0; int sum = 0; long average = 0; int count = 0;

        while(true){
            if(scanner.hasNextInt()){
                temp = scanner.nextInt();
                sum += temp;
                count++;
            } else {
                if (count == 0){
                    break;
                } else {
                    average = Math.round((double)sum/count);
                }
                break;
            }
        }
        scanner.close();
        System.out.println("SUM = " + sum + " AVG = " + average);
    }
}

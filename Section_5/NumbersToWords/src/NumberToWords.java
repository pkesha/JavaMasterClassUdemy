public class NumberToWords {

    //Converts numbers to words
    public static void numberToWords(int number){
        if (number < 0){
            System.out.println("Invalid Value");    //If it's negative
        } else if (number == 0){
            System.out.println("Zero"); //If it's a zero
        } else {

            int temp = reverse(number);
            int count = getDigitCount(number);
            //Print numbers out
            while (count != 0){
                switch (temp % 10){
                    case 0:
                        System.out.println("Zero");
                        break;
                    case 1:
                        System.out.println("One");
                        break;
                    case 2:
                        System.out.println("Two");
                        break;
                    case 3:
                        System.out.println("Three");
                        break;
                    case 4:
                        System.out.println("Four");
                        break;
                    case 5:
                        System.out.println("Five");
                        break;
                    case 6:
                        System.out.println("Six");
                        break;
                    case 7:
                        System.out.println("Seven");
                        break;
                    case 8:
                        System.out.println("Eight");
                        break;
                    case 9:
                        System.out.println("Nine");
                        break;
                }
                //Move to next digit to print
                temp /= 10;
                count--;
            }
            temp = number;

            //if temp1 = ((temp < 9) && (count > 1)) ?
            //(int)(temp * Math.pow(10, count - 1)) : temp;

        }


    }

    public static int reverse (int number){
        int temp = 0;
        int negative;

        negative = (number > 0) ? 1 : -1;

        int count = getDigitCount(number * negative);
        //System.out.println(count);

        while (count != 0){
            count--;
            temp += (number % 10) * Math.pow(10, count);
            number /= 10;
        }
        return temp;
    }

    public static int getDigitCount (int number){
        int count = 0;
        if (number == 0 ){
            return 1;
        } else if (number < 0){
            return -1;
        } else{
            while (number != 0){
                number /= 10;
                count++;
            }
            return count;
        }
    }
}

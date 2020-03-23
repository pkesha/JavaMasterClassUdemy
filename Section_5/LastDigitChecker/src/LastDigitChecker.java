public class LastDigitChecker {
    public static boolean hasSameLastDigit(int firstNumber, int secondNumber,
                                           int thirdNumber) {
        //check if the numbers in range here with if statemnt
        boolean a = ((isValid(firstNumber)) && (isValid(secondNumber)) && isValid(thirdNumber)) ?
                true : false;

        if (a && (((firstNumber % 10) == (secondNumber % 10)) ||
                ((firstNumber % 10) == (thirdNumber % 10)) ||
                ((secondNumber % 10) == (thirdNumber % 10)))){
            return true;
        }
        return false;
    }

    public static boolean isValid(int number){
        if ((number > 1000) || (number < 10)){
            return false;
        }else {
            return true;
        }
    }
}

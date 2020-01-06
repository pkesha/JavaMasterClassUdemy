public class SharedDigit {
    public static boolean hasSharedDigit (int firstNumber, int secondNumber){
        if ((firstNumber > 99) || (firstNumber < 10)
            || secondNumber > 99 || secondNumber < 10) {
            return false;
        }

        int firstDigitFirstNumber = firstNumber / 10;
        int secondDigitFirstNumber = firstNumber % 10;
        int firstDigitSecondNumber = secondNumber / 10;
        int secondDigitSecondNumber = secondNumber % 10;

        return ((firstDigitFirstNumber == firstDigitSecondNumber)
        || (firstDigitFirstNumber == secondDigitSecondNumber)
        || (secondDigitFirstNumber == firstDigitSecondNumber)
        || (secondDigitFirstNumber == secondDigitSecondNumber)) ? true : false;

    }
}

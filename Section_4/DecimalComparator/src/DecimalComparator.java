public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double doubleOne,
                                                    double doubleTwo) {
        int intOne, intTwo;
        intOne = (int)(1000 * doubleOne); intTwo = (int)(1000 * doubleTwo);

        if (intOne == intTwo){
            //System.out.println("True");
            return true;
        }else {
            //System.out.println("False");
            return  false;
        }
    }
}

public class EqualSumChecker {
    public static boolean hasEqualSum(int addOne, int addTwo, int guessResult){
        if ((addOne+addTwo) == guessResult){
            //System.out.println("true");
            return true;
        } else {
            //System.out.println("false");
            return false;
        }
    }
}

public class FlourPacker {
    public static boolean canPack (int bigCount, int smallCount, int goal) {
        if ( (goal > smallCount + (bigCount * 5)) ||
                ((goal <= -1) || (bigCount <= -1) || (smallCount <= -1)) ){
            System.out.println("1");
            return false;
        } else if ((smallCount >= 0) && (bigCount >= 0)){
            for (int i = 0; i < smallCount+1; i++){
                for (int j = 0; j < bigCount+1; j++){
                    System.out.println(i + " - " + j + ": " + (goal - i - (j*5)));
                    if ((goal - i - (5*j)) == 0){
                        return true;
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }
}

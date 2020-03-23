public class TeenNumberChecker {

    public static boolean hasTeen(int firstPerson, int secondPerson, int thirdPerson){
        if (((firstPerson < 20) && (firstPerson > 12)) ||
            ((secondPerson < 20) && (secondPerson > 12)) ||
            ((thirdPerson < 20) && (thirdPerson > 12))) {
            //System.out.println("true");
            return true;
        } else {
            //System.out.println("false");
            return false;
        }
    }

    public static boolean isTeen(int personAgeOne){
        boolean isTeen = ((personAgeOne < 20) && (personAgeOne > 12)) ? true:false;
        return isTeen;
    }
}

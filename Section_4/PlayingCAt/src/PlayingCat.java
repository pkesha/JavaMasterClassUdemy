public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature){
        if ((summer) && ((temperature <= 45 ) && (temperature >= 25))){
            return true;
        } else if (!(summer) && ((temperature <= 35 ) && (temperature >= 25))){
            return true;
        } else {
            return false;
        }
    }
}

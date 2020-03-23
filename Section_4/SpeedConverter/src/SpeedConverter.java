public class SpeedConverter {

    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        } else {
            return Math.round(kilometersPerHour / 1.609);
        }
    }

    public static void printConversion(double kilometersPerHour) {
        //If I use the above Method and check for 1, it will give me an error
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else { System.out.println(kilometersPerHour +
                    " km/h = " +
                    toMilesPerHour(kilometersPerHour) + " mi/h");
        }
    }
}

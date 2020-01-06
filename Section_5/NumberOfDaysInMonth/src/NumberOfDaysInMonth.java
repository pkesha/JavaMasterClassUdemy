public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year){
        if ((year <= 0) || (year >= 9999)) {
            System.out.println("False");
            return false;
        }else if ((((year % 4) == 0) && (!((year % 100) == 0))) || ((year % 400) == 0) ) {
            System.out.println("True");
            return true;
        } else {
            System.out.println("False");
            return false;
        }
    }

    public static int getDaysInMonth(int month, int year) {
        if ((year <= 0) || (year >= 9999)) {
            System.out.println("False");
            return -1;
        }
        switch(month) {
            case 1:
                return 31;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                }
                return 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return -1;
        }
    }
}

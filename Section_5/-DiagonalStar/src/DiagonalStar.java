public class DiagonalStar {
    public static void printSquareStar (int number){
        if (number < 5){
            System.out.println("Invalid Value");
        } else {
            int space = 0;
            for (int i = 0; i < number; i++){
                space = i;  //relationship between spaces and rows
                for (int j = 0; j < number; j++){
                    if ((j == 0) || (j == (number - 1))){
                        System.out.print("*"); //Print left and right rows
                    } else if ((i == 0) || (i == (number - 1))){
                        System.out.print("*"); //Print top and bottom rows
                    } else if (i == j || (i == (number - 1 - j))) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");//Default: space
                    }
                }
                System.out.println();
            }
        }
    }
}

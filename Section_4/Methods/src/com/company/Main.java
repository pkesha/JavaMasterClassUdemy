package com.company;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score was " + highScore);

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("Your final score was " + highScore);



        int playerScore = 1500; String player = "Cats";
        int position = calculateHighScorePosition(playerScore);
        displayHighScorePosition(player, position);

        playerScore = 900;
        position = calculateHighScorePosition(playerScore);
        displayHighScorePosition(player, position);

        playerScore = 400;
        position = calculateHighScorePosition(playerScore);
        displayHighScorePosition(player, position);

        playerScore = 50;
        position = calculateHighScorePosition(playerScore);
        displayHighScorePosition(player, position);

    }

    public static void displayHighScorePosition(String player, int position) {
        System.out.println(player + " managed to get into position " + position + " on the high score table.");
    }

    public static int calculateHighScorePosition (int playerScore) {
/*        if (playerScore >= 1000) {
            return 1;
        } else if ((playerScore >= 500)) {
            return  2;
        } else if ((playerScore >= 100)) {
            return 3;
        }
        return 4;*/

        //Another clean way to write the code from above
        int position = 4;   // Assuming position will be returned
        if (playerScore >= 1000) {
            position = 1;
        } else if (playerScore >= 500) {
            position = 2;
        } else if (playerScore >= 100) {
            position = 3;
        }

        return  position;
    }

    //Methods
    public static int calculateScore(boolean gameOver, int score,
                                      int levelCompleted, int bonus) {
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            return finalScore;
        }
            return -1;
    }
}

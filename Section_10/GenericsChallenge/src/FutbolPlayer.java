public class FutbolPlayer extends Player {
    private int goals;
    private int yellowCards;
    private int redCards;

    public FutbolPlayer(String name, int weight, int goals, int yellowCards, int redCards) {
        super(name, weight);
        this.goals = goals;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }
}

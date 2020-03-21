public class BasketballPlayer extends Player {
    private int pointsScored;
    private int fouls;

    public BasketballPlayer(String name, int weight, int pointsScored, int fouls) {
        super(name, weight);
        this.pointsScored = pointsScored;
        this.fouls = fouls;

    }

    public int getPointsScored() {
        return this.pointsScored;
    }

    public int getFouls() {
        return this.fouls;
    }
}

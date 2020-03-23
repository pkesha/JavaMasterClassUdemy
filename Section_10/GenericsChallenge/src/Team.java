import java.util.ArrayList;
import java.util.List;

public abstract class Team<T extends Player> implements Comparable<Team<Player>>{
    private ArrayList<T> team;
    private String teamName;
    private int wins;
    private int losses;
    private int ties;

    public Team(String teamName, int wins, int losses) {
        this.team = new ArrayList<>();
        this.teamName = teamName;
        this.wins = wins;
        this.losses = losses;
    }

    public boolean addPlayer(T player){
        if (this.team.contains(player)){
            System.out.println("Player " + player.getName() + " exists");
            return false;
        } else {
            this.team.add(player);
            System.out.println("Player " + player.getName() + " was added to " +
                    this.teamName);
            return true;
        }
    }

    public boolean removePlayer(T player){
        if(!this.team.contains(player)){
            System.out.println("Player " + player.getName() + " does not exist");
            return false;
        } else{
            this.team.add(player);
            System.out.println("Player " + player.getName() + " has been added");
            return true;
        }
    }

    private void gameDay(int thisTeamScore, int otherTeamScore, Team<T> otherTeam){
        if(thisTeamScore > otherTeamScore){
            this.wins++;
        } else if(thisTeamScore < otherTeamScore){
            this.losses++;
        } else{
            this.ties++;
        }
        while(otherTeam != null){
            gameDay(otherTeamScore, thisTeamScore, null);
        }
    }

    public String getTeamName() {
        return this.teamName;
    }

    public int getWins() {
        return this.wins;
    }

    public int getLosses() {
        return this.losses;
    }

    @Override
    public int compareTo(Team<Player> team) {
        if (this.getWins() > team.getWins()) return -1;
        else if (this.getWins() < team.getWins()) return 1;
        else return 0;
    }
}

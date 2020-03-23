import java.util.ArrayList;
import java.util.Collections;

public abstract class League<T extends Team> {
    private String name;
    private ArrayList<Team> league;

    public League(String name) {
        this.name = name;
        this.league = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team){
        if (this.league.contains(team)){
            System.out.println("Team " + team.getTeamName() + " exists");
            return false;
        } else {
            this.league.add(team);
            System.out.println("Team " + team.getTeamName() + " was added to " +
                    this.league);
            return true;
        }
    }

    public boolean removeTeam(T team) {
        if (!this.league.contains(team)) {
            System.out.println("Team " + team.getTeamName() + " does not exist");
            return false;
        } else {
            this.league.add(team);
            System.out.println("Team " + team.getTeamName() + " has been added");
            return true;
        }
    }

    public void displayLeaders(){
        Collections.sort(this.league);
        for(Team t : this.league){
            System.out.println(t.getTeamName() + ": " + t.getWins());
        }
    }

}

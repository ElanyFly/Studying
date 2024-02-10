package Advanced.Marathon.Participants;

import Advanced.Marathon.Competitor;

public class Team {

    private String name;
    private final Competitor[] competitors;

    public String getName() {
        return name;
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public Team(String name, Competitor[] competitors) {
        this.name = name;
        this.competitors = competitors;

    }

    public void printTeamList() {
        if (name != null && competitors != null) {
            System.out.println("Команда " + name + " включает следующих участников: ");
            for (Competitor competitor : competitors) {
                System.out.println(competitor.info());
            }
        }
    }

}

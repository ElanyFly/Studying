package Advanced.Marathon.Participants;

import Advanced.Marathon.Competitor;
import Advanced.Marathon.Obstacles.Course;
import Advanced.Marathon.Obstacles.Obstacle;

public class Team {

    String name;
    Team[] team;



    private Team(String name, Competitor... competitor){
        this.name = name;
    }

    void thoseWhoPassed() {

    }

    void teamInfo() {

    }

    Competitor[] competitors = {new Human("Eric"), new Cat ("Monty"), new Dog("Sharik"), new Human("Melissa")};

    void participants (Team[] team) {

        this.team = team;
    }


}

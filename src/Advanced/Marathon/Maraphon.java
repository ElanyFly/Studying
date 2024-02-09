package Advanced.Marathon;

import Advanced.Marathon.Obstacles.Course;
import Advanced.Marathon.Obstacles.Obstacle;
import Advanced.Marathon.Participants.Team;

import java.util.ArrayList;
import java.util.List;

public class Maraphon {

    List<Team> teamList = new ArrayList<>();
    List<Course> courseList = new ArrayList<>();

    void addTeam(Team team) {
        teamList.add(team);
    }

    void addCourse(Course team) {
        courseList.add(team);
    }

    void startMaraphon() {
        for (Team team : teamList) {
            team.printTeamList();
            for (Course course : courseList) {
                for (Obstacle obstacle : course.getCourseInit()){
                    for (Competitor competitor: team.getCompetitors()) {
                        obstacle.doIt(competitor);
                        if (!competitor.isOnDistance()){
                            System.out.println("Команда " + team.getName() + " не прошла полосу.");
                            break;
                        }
                        System.out.println("Команда " + team.getName() + " прошла полосу.");
                    }
                }


            }
        }
    }

}


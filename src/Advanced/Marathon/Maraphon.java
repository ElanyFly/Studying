package Advanced.Marathon;

import Advanced.Marathon.Obstacles.Course;
import Advanced.Marathon.Obstacles.Obstacle;
import Advanced.Marathon.Participants.Team;

import java.util.ArrayList;
import java.util.List;

public class Maraphon {

    private final List<Team> teamList = new ArrayList<>();
    private final List<Course> courseList = new ArrayList<>();
    private Speaker speaker;

    void addTeam(Team team) {
        teamList.add(team);
    }

    void addCourse(Course team) {
        courseList.add(team);
    }

    void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    void startMaraphon() {
        for (Team team : teamList) {
            team.printTeamList();
            teamTryToDoMarathon(team);
        }
    }

    // приватные методы нужны как комплекс для паблик метода (для стартмарафон)
    private void teamTryToDoMarathon(Team team) {
        for (Course course : courseList) {
            teamTryToDoObstacles(team, course);
        }
    }

    private void teamTryToDoObstacles(Team team, Course course) {
        for (Obstacle obstacle : course.getCourseInit()) {
            teamTryToDoCompetition(team, obstacle);
        }
    }

    private void teamTryToDoCompetition(Team team, Obstacle obstacle) {
        for (Competitor competitor : team.getCompetitors()) {
            obstacle.doIt(competitor);
            if (!competitor.isOnDistance()) {
                speaker.tellMarathonInfo("Команда " + team.getName() + " не прошла полосу.");           //подставляем спикер и марафон инфо, чтобы эта информация (в скобках) ушла в интерфейс
                break;
            }
            speaker.tellMarathonInfo("Команда " + team.getName() + " прошла полосу.");
        }
    }
}


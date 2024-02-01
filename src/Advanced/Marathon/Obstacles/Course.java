package Advanced.Marathon.Obstacles;

import Advanced.Marathon.Competitor;
import Advanced.Marathon.MaraphonInfo;
import Advanced.Marathon.Participants.Team;

public class Course {

//    Course[] obstacles;

    MaraphonInfo maraphonInfo;
    public void getMaraphonInfo (MaraphonInfo maraphonInfo) {
        this.maraphonInfo = maraphonInfo;
    }

    Competitor competitor;
    public void getTeamInfo (Competitor competitor) {
        this.competitor = competitor;
    }




    void passObstacleCourse() {

    }

    Obstacle[] courseInit = {new Cross(80), new Wall(2), new Wall(1), new Cross(120)};

    void startCourse (MaraphonInfo maraphonInfo) {

        for (Competitor participants : getTeamInfo()) {

        }

    }


//    void startCourse (Competitor ) {
//
//        for (Competitor teamMaraphon : participants) {
//            for (Obstacle courseRoute : courseInit) {
//                courseRoute.doIt(participants);
//                if (!participants.isOnDistance()) break;
//            }
//        }
//
//    }

}

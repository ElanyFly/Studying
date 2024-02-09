package Advanced.Marathon.Obstacles;

public class Course {

    private Obstacle[] courseInit;


    public Course(Obstacle[] courseInit) {
        this.courseInit = courseInit;
    }

    public Obstacle[] getCourseInit() {
        return courseInit;
    }


//    private void startMaraphon(Team team) {
//        for (Obstacle course : courseInit) {
//            course.doIt((Competitor) team);
//            if (!((Competitor) team).isOnDistance()){
//                break;
//            }
//        }
//    }


//    Course[] obstacles;

//    MaraphonInfo maraphonInfo;
//    public void getMaraphonInfo (MaraphonInfo maraphonInfo) {
//        this.maraphonInfo = maraphonInfo;
//    }
//
//    Competitor competitor;
//    public void getTeamInfo (Competitor competitor) {
//        this.competitor = competitor;
//    }

//    void startCourse (Competitor competitor, Obstacle[] obstacle) {
//
//        for (Competitor participants : getTeamInfo()) {
//
//        }
//
//    }

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

package Advanced.Marathon;


import Advanced.Marathon.Obstacles.Course;
import Advanced.Marathon.Obstacles.Cross;
import Advanced.Marathon.Obstacles.Obstacle;
import Advanced.Marathon.Obstacles.Wall;
import Advanced.Marathon.Participants.Cat;
import Advanced.Marathon.Participants.Dog;
import Advanced.Marathon.Participants.Human;
import Advanced.Marathon.Participants.Team;

public class Main implements MaraphonInfo {

    private final Course course = new Course();


    public static void main(String[] args) {


//        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
//        Obstacle[] course = {new Cross(80), new Wall(2), new Wall(1), new Cross(120)};
//        for (Competitor c : competitors) {
//            for (Obstacle o : course) {
//                o.doIt(c);
//                if (!c.isOnDistance()) break;
//            }
//        }
//        for (Competitor c : competitors) {
//            c.info();
//        }



    }


    @Override
    public void startMaraphon() {

    }
}



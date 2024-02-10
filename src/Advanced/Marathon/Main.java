package Advanced.Marathon;


import Advanced.Marathon.Obstacles.Course;
import Advanced.Marathon.Obstacles.Cross;
import Advanced.Marathon.Obstacles.Obstacle;
import Advanced.Marathon.Obstacles.Wall;
import Advanced.Marathon.Participants.Cat;
import Advanced.Marathon.Participants.Dog;
import Advanced.Marathon.Participants.Human;
import Advanced.Marathon.Participants.Team;

public class Main {



    public static void main(String[] args) {


        Competitor[] competitors1 = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        Team gogo = new Team("Vitalisha", competitors1);

        Competitor[] competitors = {new Human("Eric"), new Cat ("Monty"), new Dog("Sharik"), new Human("Melissa")};
        Team gogo2 = new Team("Natasha", competitors);

        Obstacle[] obstacles = {new Cross(80), new Wall(2), new Wall(1), new Cross(120)};
        Course course = new Course(obstacles);

        Obstacle[] obstacles2 = {new Cross(1000), new Wall(4)};
        Course course2 = new Course(obstacles2);

        Speaker volodya = new Speaker() {                       //володя принимает в себя инфо и озвучивает это
            @Override
            public void tellMarathonInfo(String info) {
                System.out.println(info);
            }
        };

        Maraphon maraphon = new Maraphon();
        maraphon.addTeam(gogo);
        maraphon.addTeam(gogo2);
        maraphon.addCourse(course);
        maraphon.addCourse(course2);

        maraphon.setSpeaker(                                        // сюда надо экземпляр спикера
            volodya
        );
        maraphon.startMaraphon();









//
//
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



}



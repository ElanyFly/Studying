package Advanced.Marathon;

import Advanced.Marathon.Obstacles.Course;
import Advanced.Marathon.Participants.Team;

public interface Competitor {
    void run(int dist);
    void swim(int dist);
    void jump(int height);
    boolean isOnDistance();
    void info();

}
package Advanced.Marathon.Obstacles;

public class Course {

    private Obstacle[] courseInit;

    public Course(Obstacle[] courseInit) {
        this.courseInit = courseInit;
    }

    public Obstacle[] getCourseInit() {
        return courseInit;
    }

}

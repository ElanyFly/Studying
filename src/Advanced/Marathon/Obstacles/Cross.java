package Advanced.Marathon.Obstacles;


import Advanced.Marathon.Competitor;

public class Cross extends Obstacle {
    private final int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}
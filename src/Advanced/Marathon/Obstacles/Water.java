package Advanced.Marathon.Obstacles;


import Advanced.Marathon.Competitor;

public class Water extends Obstacle {
    private final int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }
}
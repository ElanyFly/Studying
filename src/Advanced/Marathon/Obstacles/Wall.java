package Advanced.Marathon.Obstacles;


import Advanced.Marathon.Competitor;

public class Wall extends Obstacle {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}
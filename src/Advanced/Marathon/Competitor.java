package Advanced.Marathon;

public interface Competitor {
    void run(int dist);

    void swim(int dist);

    void jump(int height);

    boolean isOnDistance();

    String info();

}
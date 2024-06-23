package domain;

public class Car implements Comparable<Car>{
    private final String name;
    private int distance = 0;
    private boolean winner = false;

    public Car(String name){
        this.name = name;
    }

    public Car(String name, int distance){
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public int move(int i) {
        if(i>=4) this.distance += 1;
        return this.distance;
    }

    public int stop(int i){
        if(i<4) this.distance = i;
        return this.distance;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    @Override
    public int compareTo(Car car) {
        if(car.getDistance() < distance) {
            return 1;
        }else if(car.getDistance() > distance){
            return -1;
        }
        return 0;
    }
}

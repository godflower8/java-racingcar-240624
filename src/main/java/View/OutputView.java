package View;

import domain.Car;

import java.util.List;

public class OutputView {
    public void printResult(){
        System.out.println("실행 결과");
    }
    public void printRaceResult(List<Car> cars){
        for(Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println(makeRaceDistance(car.getDistance()));
        }
        System.out.println("");
    }

    public String makeRaceDistance(int distance){
        String raceDistance = "";
        for(int i=0; i<distance; i++){
            raceDistance = raceDistance.concat("-");
        }
        return raceDistance;
    }

    public void printFinalWinner(String winner){
        System.out.println("최종 우승자 : " + winner);
    }
}

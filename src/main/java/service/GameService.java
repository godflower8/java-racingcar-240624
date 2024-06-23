package service;

import domain.Car;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GameService {

    public String win(List<Car> cars) {

        int distance = 0;
        cars.sort(Collections.reverseOrder());

        for(Car car : cars){
            if(distance <= car.getDistance()){
                car.setWinner(true);
                distance = car.getDistance();
            }
        }

        return cars.stream()
                .filter(Car::isWinner)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    public List<Car> race(List<Car> cars){
        int randomNumber = 0;
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        for(Car car : cars){
            randomNumber = random.nextInt(9);
            car.move(randomNumber);
        }

        return cars;
    }
}

package controller;

import View.InputView;
import View.OutputView;
import domain.Car;
import service.GameService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameController {
    InputView iv = new InputView();
    OutputView ov = new OutputView();
    GameService gameService = new GameService();

    public void play(){
        Scanner sc = new Scanner(System.in);

        //입력 - 자동차 이름
        iv.requestInputName();
        List<Car> cars = inputCarNames(sc);
        //입력 - 경주 횟수
        iv.requestInputRaceCount();
        int raceCount = inputRaceCount(sc);
        //경주
        ov.printResult();
        cars = raceWithCount(cars, raceCount);
        //출력 - 우승자
        String winner = gameService.win(cars);
        ov.printFinalWinner(winner);
    }

    private List<Car> raceWithCount(List<Car> cars, int raceCount) {
        for(int i = 0; i< raceCount; i++){
            cars = gameService.race(cars);
            ov.printRaceResult(cars);
        }
        return cars;
    }

    private int inputRaceCount(Scanner sc) {
        int raceCount = 0;
        try {
            raceCount = sc.nextInt();
        }catch(IllegalArgumentException e){
            inputRaceCount(sc);
        }
        return raceCount;
    }

    private static List<Car> inputCarNames(Scanner sc) {
        String[] carNames = new String[]{};
        try {
            carNames = sc.nextLine().split(",");
        }catch(IllegalArgumentException e){
            inputCarNames(sc);
        }
        List<String> list = new ArrayList<>(Arrays.asList(carNames));
        return list.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

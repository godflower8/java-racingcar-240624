package service;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {
    @Test
    @DisplayName("게임을 1번 진행한다.")
    void raceTest(){
        //given
        Car aCar = new Car("a");
        Car bCar = new Car("b");
        Car cCar = new Car("c");

        //when
        aCar.move(5);
        bCar.move(3);
        cCar.move(9);
        List<Car> cars = List.of(aCar, bCar, cCar);
        GameService gameService = new GameService();
        //gameService.race(cars);

        //then
        assertThat(aCar.getDistance()).isEqualTo(1);
        assertThat(bCar.getDistance()).isEqualTo(0);
        assertThat(cCar.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승을 판별한다.")
    void winTest(){
        //given
        Car aCar = new Car("a");
        Car bCar = new Car("b");
        Car cCar = new Car("c");
        aCar.move(5);
        bCar.move(4);
        cCar.move(3);

        //when
        List<Car> cars = new ArrayList<>();
        cars.add(aCar);
        cars.add(bCar);
        cars.add(cCar);
        GameService gameService = new GameService();
        String winner = gameService.win(cars);

        //then
        assertThat(winner).isEqualTo("a,b");
    }
}
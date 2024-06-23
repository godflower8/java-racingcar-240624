package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("자동차를 이름과 함께 생성한다.")
    void generateTest(){
        //given
        //when
        Car car = new Car("pobi");
        //then
        assertThat(car).isInstanceOf(Car.class);
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차는 랜덤 수가 4 이상이면, 전진한다.")
    void moveTest(){
        //given
        Car aCar = new Car("a");
        Car bCar = new Car("b");

        //when
        int aDistance = aCar.move(5);
        int bDistance = bCar.move(3);

        //then
        assertThat(aCar.getDistance()).isEqualTo(1);
        assertThat(bCar.getDistance()).isEqualTo(0);
    }
}
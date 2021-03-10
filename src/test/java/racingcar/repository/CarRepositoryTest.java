package racingcar.repository;

import com.sun.jmx.mbeanserver.Repository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.CarService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    @Test
    @DisplayName("자동차 추가 검증 로직 테스트")
    public void save() throws Exception {
        //given
        CarRepository carRepository = new CarRepository();
        Car car = new Car();
        String name = "seongbeen";
        car.setName(name);

        //when
        carRepository.save(car);
        int currentSize = carRepository.findAll().size();
        Car foundCar = carRepository.findByName(name);

        //then
        assertEquals(1, currentSize, "추가한 만큼 크기가 증가해야 한다.");
        assertEquals(car.hashCode(), foundCar.hashCode(), "추가한 자동차와 꺼낸 자동차가 같아야 한다.");
    }
}
package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public enum CarRepository {

    INSTANCE;

    private final List<Car> cars = new ArrayList<>();

    public void save(Car car) {
        cars.add(car);
    }
}

package racingcar.repository;

import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.domain.Position;
import racingcar.utils.RandomNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class CarRepository {

    private final static int MIN_MOVEMENT_RANGE = 0;
    private final List<Car> cars = new ArrayList<>();

    public void save(Car car) {
        cars.add(car);
    }

    public List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }

    public Queue<Integer> findAllMovementRange() {
        return cars.stream()
                .map(Car::getPosition)
                .map(Position::getPosition)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Queue<String> findAllNames() {
        return cars.stream()
                .map(Car::getName)
                .map(Name::getName)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Queue<String> findWinnersByMaxMovementRange(int maxMovementRange) {
        return cars.stream()
                .filter(car -> car.isWinner(maxMovementRange))
                .map(Car::getName)
                .map(Name::getName)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Car findByName(String name) {
        return cars.stream()
                .filter(car -> name.equals(car.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 자동차가 없습니다."));
    }

    public int findMaxMovementRange() {
        return cars.stream()
                .map(Car::getPosition)
                .map(Position::getPosition)
                .max(Integer::compareTo)
                .orElse(MIN_MOVEMENT_RANGE);
    }

    public void updateCarsMovementRange() {
        cars.forEach(car -> car.move(RandomNumberGenerator.generate()));
    }
}

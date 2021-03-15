package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final String CHECK_RANDOM_NUMBER_BOUND = "이동 범위의 조건은 0 ~ 9이여야만 합니다.";
    private static final int CONDITION_FOR_MOVEMENT = 4;
    private static final int MAX_INCLUSIVE = 9;
    private static final int MIN_INCLUSIVE = 0;
    private Position position;
    private final Name name;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(int number) {
        validateRandomNumberBound(number);
        if (number >= CONDITION_FOR_MOVEMENT) {
            position = position.move();
        }
    }

    public boolean isWinner(int maxPosition) {
        return this.position.isSame(maxPosition);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    private void validateRandomNumberBound(int randomNumber) {
        if (randomNumber > MAX_INCLUSIVE || randomNumber < MIN_INCLUSIVE) {
            throw new IllegalArgumentException(CHECK_RANDOM_NUMBER_BOUND);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}

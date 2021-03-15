package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final String CHECK_NEGATIVE = "이동범위가 음수 값인지 확인해주세요.";
    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        validateNegative(position);
        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public boolean isSame(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    private void validateNegative(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(CHECK_NEGATIVE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}

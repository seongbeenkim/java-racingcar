package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    @DisplayName("위치 생성 테스트")
    public void create() throws Exception {
        //when
        Position position = new Position(4);

        //then
        assertThat(position).isEqualTo(new Position(4));
    }

    @ParameterizedTest(name = "\"{0}\" = 음수")
    @ValueSource(ints = {-1, -2, -3, -4})
    @DisplayName("음수 입력 오류 테스트")
    public void validateNegative(int negative) throws Exception {
        assertThatThrownBy(() -> {
            new Position(negative);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("위치 이동 테스트")
    public void move() throws Exception {
        //given
        Position position = new Position(4);

        //then
        assertThat(position.move()).isEqualTo(new Position(5));
    }

    @Test
    @DisplayName("최대 이동범위 검증 테스트")
    public void isSame() throws Exception {
        //given
        int maxPosition = 9;

        //when
        Position position = new Position(9);

        //then
        assertThat(position.isSame(maxPosition)).isEqualTo(true);
    }
}

package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름 생성 테스트")
    public void create() throws Exception {
        Name name = new Name("sean");
        assertThat(name).isEqualTo(new Name("sean"));
    }

    @Test
    @DisplayName("이름 검증 테스트")
    public void validate() throws Exception {
        assertThatThrownBy(() -> new Name(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name("seongbeen")).isInstanceOf(IllegalArgumentException.class);
    }
}
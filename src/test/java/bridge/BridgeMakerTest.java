package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {

    @DisplayName("다리의 길이로 입력받은 값이 정수형인지 확인한다.")
    @ValueSource(strings = {"문자","🍖"," ",""})
    @Test
    void validate_Is_Number(BridgeNumberGenerator input) {
        assertThatThrownBy(()-> new BridgeMaker(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("다리의 길이로 입력받은 값이 \"(int)48~ (int)57\"과 같은 형식인지 확인한다.")
    @ValueSource(ints = {(int)51,(int)57})
    @Test
    void validate_unintentional_Way_Of_Input(BridgeNumberGenerator input) {
        assertThatThrownBy(()-> new BridgeMaker(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("다리의 길이로 입력받은 값이 정수형으로 3 이상 20 이하인지 확인한다.")
    @ValueSource(ints = {2,-3, 0, 21,})
    @Test
    void validate_Is_Number_In_Range(BridgeNumberGenerator input) {
        assertThatThrownBy(()-> new BridgeMaker(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
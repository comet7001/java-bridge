package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("사용자가 'U'나 'D'가 아닌 값을 입력했는지 확인한다.")
    @ValueSource(strings = {"u","🍖","d"})
    @Test
    void validate_Is_There_Only_Up_And_Down(InputView input) {
        assertThatThrownBy(()-> new BridgeGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("사용자가 (char)85, (char)68로 U, D를 입력하는지 확인한다.")
    @ValueSource(chars = {(char)85,(char)68})
    @Test
    void validate_Is_Unintentional_Character_Input(InputView input) {
        assertThatThrownBy(()-> new BridgeGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("사용자가 U, D를 입력할 때 공백을 넣으면 자동으로 트리밍하여 예외처리가 발생하지 않도록 한다.")
    @ValueSource(strings = {" U","D "," U "})
    @Test
    void validate_Is_Acceptable_Blank_Input_Of_Character(InputView input) {
        assertThatThrownBy(()-> new BridgeGame(input))
                .isNotInstanceOf(IllegalArgumentException.class)
                .hasMessageNotContaining("[ERROR]");
    }

    // 가구현
    @DisplayName("캐릭터의 이동 방향이 항상 왼쪽에서 오른쪽인지 확인한다.")
    @Test
    void validate_Is_Direction_From_Left_To_Right() {
        assertThatThrownBy(()-> new BridgeGame())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}
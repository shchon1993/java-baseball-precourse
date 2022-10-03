package baseball.model;

import baseball.domain.baseBallGame;
import baseball.domain.baseBallUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;



public class baseBallGameServiceImpleTest {
    private baseBallGameServiceImple serviceImple = new baseBallGameServiceImple();

    @DisplayName("사용자 입력 테스트(2개 이하의 숫자 입력했을 경우)")
    @Test
    void createusernumundercnt() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            serviceImple.createusernum("12");
        });
    }

    @DisplayName("사용자 입력 테스트(4개 이상의 숫자 입력했을 경우)")
    @Test
    void createusernumovercnt() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            serviceImple.createusernum("1234");
        });
    }
    @DisplayName("사용자 입력 테스트(중복 숫자 입력)")
    @Test
    void createusernumrepeat() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            serviceImple.createusernum("133");
        });
    }
    @DisplayName("사용자 입력 테스트(정상)")
    @Test
    void createusernum() {
        baseBallUser user = new baseBallUser();
        user.setUser(Arrays.asList(5,4,2));
        assertThat(user.getUser().size()).isEqualTo(3);
    }
    @DisplayName("컴퓨터 번호 생성(3자리)")
    @Test
    void createnum() {
        baseBallGame game = new baseBallGame();
        game.setBall(serviceImple.createnum());
        assertThat(game.getBall().size()).isEqualTo(3);
    }
    @DisplayName("컴퓨터 번호 중복된 자리 생성")
    @Test
    void createnumrepeat() {
        baseBallGame game = new baseBallGame();
        game.setBall(serviceImple.createnum());
        assertThat(game.getBall().get(0)).isNotEqualTo(game.getBall().get(1));
        assertThat(game.getBall().get(0)).isNotEqualTo(game.getBall().get(2));
        assertThat(game.getBall().get(1)).isNotEqualTo(game.getBall().get(2));
    }





}

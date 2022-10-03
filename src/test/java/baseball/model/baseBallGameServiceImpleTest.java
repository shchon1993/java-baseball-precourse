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
    @DisplayName("스트라이크 수 0~3")
    @Test
    public void strike(){
        baseBallGame game = new baseBallGame();
        baseBallUser user = new baseBallUser();
        game.setBall(Arrays.asList(3,2,4));
        user.setUser(Arrays.asList(1,2,3));
        int strike_cnt = serviceImple.strike(game,user);
        assertThat(strike_cnt).isLessThan(4).isGreaterThan(-1);
    }
    @DisplayName("낫싱")
    @Test
    public void nothing(){
        baseBallGame game = new baseBallGame();
        baseBallUser user = new baseBallUser();
        game.setBall(Arrays.asList(4,5,6));
        user.setUser(Arrays.asList(1,2,3));
        int strike_cnt = serviceImple.strike(game,user);
        int ball_cnt = serviceImple.ball(game,user);
        assertThat(strike_cnt).isEqualTo(0);
        assertThat(ball_cnt).isEqualTo(0);
    }
    @DisplayName("스트라이크,볼")
    @Test
    public void strikeCnt(){
        baseBallGame game = new baseBallGame();
        baseBallUser user = new baseBallUser();
        game.setBall(Arrays.asList(4,5,2));
        user.setUser(Arrays.asList(4,2,3));
        int strike_cnt = serviceImple.strike(game,user);
        int ball_cnt = serviceImple.ball(game,user);
        assertThat(strike_cnt).isEqualTo(1);
        assertThat(ball_cnt).isEqualTo(1);
    }
    @DisplayName("볼 수 0 ~ 3")
    @Test
    public void ball(){
        baseBallGame game = new baseBallGame();
        baseBallUser user = new baseBallUser();
        game.setBall(Arrays.asList(3,2,4));
        user.setUser(Arrays.asList(1,2,3));
        int ball_cnt = serviceImple.ball(game,user);
        assertThat(ball_cnt).isLessThan(4).isGreaterThan(-1);
    }




}

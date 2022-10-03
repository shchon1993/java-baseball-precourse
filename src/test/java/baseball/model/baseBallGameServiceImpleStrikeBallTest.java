package baseball.model;

import baseball.domain.baseBallGame;
import baseball.domain.baseBallUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class baseBallGameServiceImpleStrikeBallTest {
    private baseBallGameServiceImple serviceImple = new baseBallGameServiceImple();

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
    @DisplayName("1B0S")
    @Test
    public void strikeBall1(){
        baseBallGame game = new baseBallGame();
        baseBallUser user = new baseBallUser();
        game.setBall(Arrays.asList(4,5,2));
        user.setUser(Arrays.asList(8,2,3));
        int strike_cnt = serviceImple.strike(game,user);
        int ball_cnt = serviceImple.ball(game,user);
        assertThat(strike_cnt).isEqualTo(0);
        assertThat(ball_cnt).isEqualTo(1);
    }
    @DisplayName("1B1S")
    @Test
    public void strikeBall2(){
        baseBallGame game = new baseBallGame();
        baseBallUser user = new baseBallUser();
        game.setBall(Arrays.asList(4,5,2));
        user.setUser(Arrays.asList(4,2,3));
        int strike_cnt = serviceImple.strike(game,user);
        int ball_cnt = serviceImple.ball(game,user);
        assertThat(strike_cnt).isEqualTo(1);
        assertThat(ball_cnt).isEqualTo(1);
    }
    @DisplayName("2B0S")
    @Test
    public void strikeBall3(){
        baseBallGame game = new baseBallGame();
        baseBallUser user = new baseBallUser();
        game.setBall(Arrays.asList(4,5,2));
        user.setUser(Arrays.asList(2,3,4));
        int strike_cnt = serviceImple.strike(game,user);
        int ball_cnt = serviceImple.ball(game,user);
        assertThat(strike_cnt).isEqualTo(0);
        assertThat(ball_cnt).isEqualTo(2);
    }
    @DisplayName("2B1S")
    @Test
    public void strikeBall4(){
        baseBallGame game = new baseBallGame();
        baseBallUser user = new baseBallUser();
        game.setBall(Arrays.asList(3,2,4));
        user.setUser(Arrays.asList(4,2,3));
        int strike_cnt = serviceImple.strike(game,user);
        int ball_cnt = serviceImple.ball(game,user);
        assertThat(strike_cnt).isEqualTo(1);
        assertThat(ball_cnt).isEqualTo(2);
    }
     @DisplayName("3B0S")
    @Test
    public void strikeBall5(){
        baseBallGame game = new baseBallGame();
        baseBallUser user = new baseBallUser();
        game.setBall(Arrays.asList(4,5,2));
        user.setUser(Arrays.asList(2,4,5));
        int strike_cnt = serviceImple.strike(game,user);
        int ball_cnt = serviceImple.ball(game,user);
        assertThat(strike_cnt).isEqualTo(0);
        assertThat(ball_cnt).isEqualTo(3);
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

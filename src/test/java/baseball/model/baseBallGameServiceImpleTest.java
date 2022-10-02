package baseball.model;

import baseball.domain.baseBallGame;
import baseball.domain.baseBallUser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class baseBallGameServiceImpleTest {
    private baseBallGameServiceImple serviceImple = new baseBallGameServiceImple();

    @Test
    public void createusernum() {
        //given
        int testarr[] = new int[3];
        //when
        testarr = serviceImple.createusernum();
        //then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()-> serviceImple.createusernum());
        assertThat(e.getMessage()).isEqualTo("숫자를 잘못 입력하였습니다.");
    }
    @Test
    public void createnum(){
        String repeatNumChk = "";
        List<Integer> numbers  = new ArrayList<>();
        int game_arr[] = new int[3];
        for(int i=1;i<=9;i++){
            numbers.add(i);
        }
        for(int i = 0; i<3; i++){
            game_arr[i] = serviceImple.createrepeatnum(numbers);
        }
        int test[] = {1,2,3,4,5,7,8,9};
        assertThat(game_arr).contains(test);
    }

    @Test
    public void strike(){
        baseBallGame game = new baseBallGame();
        baseBallUser user = new baseBallUser();
        int gameArr[] = {2,3,4};
        int userArr[] = {1,2,3};
        game.setBall(gameArr);
        user.setUser(userArr);
        int strike_cnt = serviceImple.strike(game,user);
        assertThat(strike_cnt).isLessThan(4).isGreaterThan(-1);
    }
    @Test
    public void ball(){
        baseBallGame game = new baseBallGame();
        baseBallUser user = new baseBallUser();
        int gameArr[] = {2,3,4};
        int userArr[] = {1,2,3};
        game.setBall(gameArr);
        user.setUser(userArr);
        int strike_cnt = serviceImple.ball(game,user);
        assertThat(strike_cnt).isLessThan(4).isGreaterThan(-1);
    }



}

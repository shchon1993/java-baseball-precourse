package baseball.model;

import baseball.domain.baseBallGame;
import baseball.domain.baseBallUser;
import baseball.view.baseBallMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class baseBallGameServiceImple implements baseBallGameService{
    private baseBallMessage message = new baseBallMessage();
    private static int user_arr[] = new int[3];
    private static List<Integer> game_num;
    private static int user_num[] = new int[3];
    private static int strike_cnt = 0;
    private static int ball_cnt = 0;
    private static List<Integer> game_ball;

    //사용자 숫자 입력
    public int[] createusernum(){
        message.inputNumberMessage();
        String str = Console.readLine();
        String strarr[] = str.split("");
        createusernumException(strarr);
        for (int i = 0; i < 3; i++) {
            user_arr[i] = Integer.parseInt(strarr[i]);
        }
        return  user_arr;
    }
    public void createusernumException(String strarr[]){
        if(strarr.length != 3)
            throw new IllegalArgumentException("3개의 숫자만 입력해주세요.");
        if(Integer.parseInt(strarr[0]) == Integer.parseInt(strarr[1]) || Integer.parseInt(strarr[0]) == Integer.parseInt(strarr[2]) || Integer.parseInt(strarr[1]) == Integer.parseInt(strarr[2]))
            throw new IllegalArgumentException("중복된 숫자를 입력하지 마세요.");
        if(Integer.parseInt(strarr[0]) >= 10 || Integer.parseInt(strarr[0]) <= 0)
            throw new IllegalArgumentException("1~9범위 내 숫자만 입력해주세요");
        if(Integer.parseInt(strarr[1]) >= 10 || Integer.parseInt(strarr[1]) <= 0)
            throw new IllegalArgumentException("1~9범위 내 숫자만 입력해주세요");
        if(Integer.parseInt(strarr[2]) >= 10 || Integer.parseInt(strarr[2]) <= 0)
            throw new IllegalArgumentException("1~9범위 내 숫자만 입력해주세요");
    }
    public List<Integer> createnum(){
        game_ball = new LinkedList<>();
        int num = 0;
        int i = 0;
        while(i<3){
           num = Randoms.pickNumberInRange(1,9);
           i = createnumrepeatchk(num,i);
        }
        return game_ball;
    }
    public int createnumrepeatchk(int number, int i){
        if(!game_ball.contains(number)){
            game_ball.add(number);
            i++;
        }
        return i;
    }
    public int strike(baseBallGame game, baseBallUser user){
        strike_cnt = 0;
        game_num = game.getBall();
        user_num = user.getUser();
        if(game_num.get(0) == user_num[0]) strike_cnt++;
        if(game_num.get(1) == user_num[1]) strike_cnt++;
        if(game_num.get(2) == user_num[2]) strike_cnt++;
        return strike_cnt;
    }
    public int ball(baseBallGame game,  baseBallUser user){
        ball_cnt = 0;
        game_num = game.getBall();
        user_num = user.getUser();
        if((game_num.get(1) == user_num[0]) || (game_num.get(2) == user_num[0])) ball_cnt++;
        if((game_num.get(0) == user_num[1]) || (game_num.get(2) == user_num[1])) ball_cnt++;
        if((game_num.get(0) == user_num[2]) || (game_num.get(1) == user_num[2])) ball_cnt++;
        return ball_cnt;
    }
    public int end(){
        message.baseballGameEndYnMessage();
        String str = Console.readLine();
        if(!(str.equals("1") || str.equals("2")))
            throw new IllegalArgumentException("1,2 중 하나의 숫자만 입력해주세요.");
        if(str.equals("2")) {
            return 2;
        }
        return 1;
    }
}

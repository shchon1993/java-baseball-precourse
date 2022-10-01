package baseball.model;

import baseball.domain.baseBallGame;
import baseball.domain.baseBallUser;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class baseBallGameServiceImple implements baseBallGameService{
    private static int game_arr[] =new int[3];
    private static int user_arr[] = new int[3];
    private static List<Integer> numbers  = new ArrayList<>();
    private static String repeatNumChk = "";
    private static int game_num[] = new int[3];
    private static int user_num[] = new int[3];
    private static int strike_cnt = 0;
    private static int ball_cnt = 0;
    private static boolean finish;

    //사용자 숫자 입력
    public int[] createusernum() {
        System.out.print("숫자를 입력해 주세요 : ");
        String str = Console.readLine();
        String strarr[] = str.split("");
        for (int i = 0; i < 3; i++) {
            user_arr[i] = Integer.parseInt(strarr[i]);
        }
        return  user_arr;
    }

    //난수 생성
    public int[] createnum(){
        repeatNumChk = "";
        for(int i=1;i<=9;i++){
            numbers.add(i);
        }
        for(int i = 0; i<3; i++){
            game_arr[i] = createrepeatnum();
        }
        return game_arr;
    }

    //중복체크하여 난수 생성
    public static int createrepeatnum(){
        int temp = Randoms.pickNumberInList(numbers);
        finish = createrepeatnumchk(temp);
        if(!finish){
            repeatNumChk += String.valueOf(temp);
            return temp;
        }
        while(finish){
            temp = Randoms.pickNumberInList(numbers);
            finish = createrepeatnumchk(temp);
        }
        repeatNumChk += String.valueOf(temp);
        return temp;
    }
    public static boolean createrepeatnumchk(int num){
        boolean finishTemp = repeatNumChk.contains(String.valueOf(num));
        return finishTemp;
    }
    //스트라이크
    public int strike(baseBallGame game, baseBallUser user){
        strike_cnt = 0;
        game_num = game.getBall();
        user_num = user.getUser();
        if(game_num[0] == user_num[0]) strike_cnt++;
        if(game_num[1] == user_num[1]) strike_cnt++;
        if(game_num[2] == user_num[2]) strike_cnt++;
        return strike_cnt;
    }
    //볼
    public int ball(baseBallGame game,  baseBallUser user){
        ball_cnt = 0;
        game_num = game.getBall();
        user_num = user.getUser();
        if((game_num[1] == user_num[0]) || (game_num[2] == user_num[0])) ball_cnt++;
        if((game_num[0] == user_num[1]) || (game_num[2] == user_num[1])) ball_cnt++;
        if((game_num[0] == user_num[2]) || (game_num[1] == user_num[2])) ball_cnt++;
        return ball_cnt;
    }
}

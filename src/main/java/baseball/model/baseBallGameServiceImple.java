package baseball.model;

import baseball.domain.baseBallGame;
import baseball.domain.baseBallUser;
import baseball.view.baseBallMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class baseBallGameServiceImple implements baseBallGameService{
    private baseBallMessage message = new baseBallMessage();
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
    public int[] createusernum() throws IllegalArgumentException{
        message.inputNumberMessage();
        String str = Console.readLine();
        String strarr[] = str.split("");
        createusernumException(strarr);
        for (int i = 0; i < 3; i++) {
            user_arr[i] = Integer.parseInt(strarr[i]);
        }
        return  user_arr;
    }
    public void createusernumException(String strarr[]) throws IllegalArgumentException{
        if(strarr.length != 3)
            throw new IllegalArgumentException();
        if(Integer.parseInt(strarr[0]) == Integer.parseInt(strarr[1]) || Integer.parseInt(strarr[0]) == Integer.parseInt(strarr[2]) || Integer.parseInt(strarr[1]) == Integer.parseInt(strarr[2]))
            throw new IllegalArgumentException();
        if(Integer.parseInt(strarr[0]) >= 10 && Integer.parseInt(strarr[0]) <= 0)
            throw new IllegalArgumentException();
        if(Integer.parseInt(strarr[1]) >= 10 && Integer.parseInt(strarr[1]) <= 0)
            throw new IllegalArgumentException();
        if(Integer.parseInt(strarr[2]) >= 10 && Integer.parseInt(strarr[2]) <= 0)
            throw new IllegalArgumentException();
    }

    //난수 생성
    public int[] createnum(){
        repeatNumChk = "";
        for(int i=1;i<=9;i++){
            numbers.add(i);
        }
        for(int i = 0; i<3; i++){
            game_arr[i] = createrepeatnum(numbers);
        }
        return game_arr;
    }

    //중복체크하여 난수 생성
    public static int createrepeatnum(List<Integer> num){
        int temp = Randoms.pickNumberInList(num);
        finish = createrepeatnumchk(temp);
        if(!finish){
            repeatNumChk += String.valueOf(temp);
            return temp;
        }
        temp = createrepeat();
        repeatNumChk += String.valueOf(temp);
        return temp;
    }
    public static boolean createrepeatnumchk(int num){
        boolean finishTemp = repeatNumChk.contains(String.valueOf(num));
        return finishTemp;
    }
    public static int createrepeat(){
        int temp = 0;
        while(finish){
            temp = Randoms.pickNumberInList(numbers);
            finish = createrepeatnumchk(temp);
        }
        return temp;
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
    public int end() throws IllegalArgumentException{
        message.baseballGameEndYnMessage();
        String str = Console.readLine();
        if(!(str.equals("1") || str.equals("2")))
            throw new IllegalArgumentException();
        if(str.equals("2")) {
            return 2;
        }
        return 1;
    }
}

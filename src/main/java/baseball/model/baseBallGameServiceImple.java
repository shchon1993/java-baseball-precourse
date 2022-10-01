package baseball.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class baseBallGameServiceImple implements baseBallGameService{
    private static int game_arr[] =new int[3];
    private static int user_arr[] = new int[3];
    private static List<Integer> numbers  = new ArrayList<>();
    private static String repeatNumChk = "";

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
        repeatNumChk += String.valueOf(temp);
        while(repeatNumChk.contains(String.valueOf(temp))){
            temp = Randoms.pickNumberInList(numbers);
        }
        return temp;
    }
}

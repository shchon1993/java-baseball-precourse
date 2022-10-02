package baseball.view;

public class baseBallMessage {
    public void inputNumberMessage(){
        System.out.print("숫자를 입력해 주세요 : ");
    }
    public String getStrikeMessage(){
        return "스트라이크";
    }
    public String getBallMessage(){
        return "볼";
    }
    public void getNothingMessage(){
        System.out.println("낫싱");
    }
    public void get3StrikeMessage(){
        System.out.println("3스트라이크");
    }
    public void baseballGameEndYnMessage(){
        System.out.println("3개의숫자를모두맞히셨습니다!게임종료\n" + "게임을새로시작하려면1,종료하려면2를입력하세요.");
    }
}

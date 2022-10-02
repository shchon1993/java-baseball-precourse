package baseball.view;


import baseball.domain.baseBallGame;

public class baseBallView {
    private static baseBallMessage message = new baseBallMessage();
    public String view(int strike_cnt, int ball_cnt, baseBallGame game) {
        if(strike_cnt == 0 && ball_cnt == 0){
            message.getNothingMessage();
            return "N";
        }
        if (strike_cnt == 3){
            message.get3StrikeMessage();
            return "Y";
        }
        getballStrikeMessage(game);
        return "N";
    }
    public static void getballStrikeMessage(baseBallGame game){
        System.out.println(game.getBall_cnt()+message.getBallMessage()+" "+game.getStrike_cnt()+message.getStrikeMessage());
    }

}

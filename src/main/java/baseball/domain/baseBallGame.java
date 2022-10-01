package baseball.domain;

public class baseBallGame {
    private int ball[];
    private int strike_cnt;
    private int ball_cnt;
    private int game_yn;

    public int getGame_yn() {
        return game_yn;
    }
    public void setGame_yn(int game_yn) {
        this.game_yn = game_yn;
    }
    public int getBall_cnt() {
        return ball_cnt;
    }
    public void setBall_cnt(int ball_cnt) {
        this.ball_cnt = ball_cnt;
    }
    public int getStrike_cnt() {
        return strike_cnt;
    }
    public void setStrike_cnt(int strike_cnt) {
        this.strike_cnt = strike_cnt;
    }
    public int[] getBall() {
        return ball;
    }
    public void setBall(int[] ball) {
        this.ball = ball;
    }
}

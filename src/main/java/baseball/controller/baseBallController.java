package baseball.controller;


import baseball.domain.baseBallGame;
import baseball.domain.baseBallUser;
import baseball.model.baseBallGameService;
import baseball.model.baseBallGameServiceImple;

public class baseBallController {
    private static baseBallUser user = new baseBallUser();
    private static baseBallGame game = new baseBallGame();
    private baseBallGameService baseBallService = new baseBallGameServiceImple();

    public void run() {
        int i = 0;
        while(i<10) {
            game.setBall(baseBallService.createnum());
            int arr[] = game.getBall();
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
            user.setUser(baseBallService.createusernum());
            game.setStrike_cnt(baseBallService.strike(game, user));
            game.setBall_cnt(baseBallService.ball(game, user));
            System.out.println(game.getBall_cnt() + "볼" + game.getStrike_cnt() + "스트라이크");
            i++;
        }
    }

}

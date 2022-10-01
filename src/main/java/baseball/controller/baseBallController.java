package baseball.controller;


import baseball.domain.baseBallGame;
import baseball.domain.baseBallUser;
import baseball.model.baseBallGameService;
import baseball.model.baseBallGameServiceImple;

public class baseBallController {
    private static baseBallUser user = new baseBallUser();
    private static baseBallGame game = new baseBallGame();
    private baseBallGameService baseBallService = new baseBallGameServiceImple();

    public void run(){
        game.setBall(baseBallService.createnum());
        int arr[] = game.getBall();
        System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        user.setUser(baseBallService.createusernum());
    }

}

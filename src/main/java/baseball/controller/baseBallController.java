package baseball.controller;


import baseball.domain.baseBallGame;
import baseball.domain.baseBallUser;
import baseball.model.baseBallGameService;
import baseball.model.baseBallGameServiceImple;
import baseball.view.baseBallView;

public class baseBallController {
    private static baseBallUser user = new baseBallUser();
    private static baseBallGame game = new baseBallGame();
    private baseBallGameService baseBallService = new baseBallGameServiceImple();
    private static baseball.view.baseBallView baseBallView = new baseBallView();
    private static String result = "";
    private static boolean endGameYn = true;
    private static boolean initGame = true;
    private static int endGame = 0;

    public void run() {
        while(endGameYn) {
            gameSetting();
            result = baseBallView.view(game.getStrike_cnt(), game.getBall_cnt(), game);
            System.out.println(result);
            if(result.equals("Y"))
                endGame();
        }
    }
    public void gameSetting(){
        if(initGame) {
            game.setBall(baseBallService.createnum());
            int arr[] = game.getBall();
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }
        user.setUser(baseBallService.createusernum());
        game.setStrike_cnt(baseBallService.strike(game, user));
        game.setBall_cnt(baseBallService.ball(game, user));
        initGame = false;
    }
    public void endGame(){
        if (result.equals("Y")) {
            endGame = baseBallService.end();
        }
        if(endGame == 2){
            endGameYn = false;
            return;
        }
        endGameYn = true;
        initGame = true;
    }
}

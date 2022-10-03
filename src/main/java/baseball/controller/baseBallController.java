package baseball.controller;


import baseball.domain.baseBallGame;
import baseball.domain.baseBallUser;
import baseball.model.baseBallGameService;
import baseball.model.baseBallGameServiceImple;
import baseball.view.baseBallMessage;
import baseball.view.baseBallView;
import camp.nextstep.edu.missionutils.Console;

public class baseBallController {
    private static baseBallUser user;
    private static baseBallGame game;
    private baseBallGameService baseBallService = new baseBallGameServiceImple();
    private baseBallView baseBallView = new baseBallView();
    private baseBallMessage message = new baseBallMessage();
    private static String result;
    private static boolean endGameYn;
    private static boolean initGame;
    private static int endGame;

    public void init(){
        endGameYn = true;
        initGame = true;
        endGame = 0;
        result = "";
        user = new baseBallUser();
        game = new baseBallGame();
    }

    public void run() {
        init();
        while(endGameYn) {
            gameSetting();
            result = baseBallView.view(game.getStrike_cnt(), game.getBall_cnt(), game);
            end(result);
        }
    }
    public void gameSetting(){
        if(initGame) {
            game.setBall(baseBallService.createnum());
        }
        message.inputNumberMessage();
        String str = Console.readLine();
        user.setUser(baseBallService.createusernum(str));
        game.setStrike_cnt(baseBallService.strike(game, user));
        game.setBall_cnt(baseBallService.ball(game, user));
        initGame = false;
    }
    public void end(String result){
        if(result.equals("Y"))
            endGame();
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

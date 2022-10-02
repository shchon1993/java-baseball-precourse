package baseball.model;

import baseball.domain.baseBallGame;
import baseball.domain.baseBallUser;

public interface baseBallGameService {
    int[] createusernum();
    int[] createnum();
    int strike(baseBallGame game, baseBallUser user);
    int ball(baseBallGame game, baseBallUser user);
    int end();
}

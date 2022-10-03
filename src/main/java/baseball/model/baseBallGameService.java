package baseball.model;

import baseball.domain.baseBallGame;
import baseball.domain.baseBallUser;

import java.util.List;

public interface baseBallGameService {
    List<Integer> createusernum(String str);
    List<Integer> createnum();
    int strike(baseBallGame game, baseBallUser user);
    int ball(baseBallGame game, baseBallUser user);
    int end();
}

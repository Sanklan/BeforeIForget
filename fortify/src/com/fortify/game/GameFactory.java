package com.fortify.game;

import com.fortify.ErrorMessage;
import com.fortify.rule.BoxRule;
import com.fortify.rule.ColumnRule;
import com.fortify.rule.EmptyRule;
import com.fortify.rule.RowRule;

public class GameFactory {
    
    public static Game createGame (GameType type, int[][] cells) throws GameException{
        switch(type) {
            case Sudoku:
            {
                return (new Game.Builder()
                .addRule(new EmptyRule())
                .addRule(new RowRule())
                .addRule(new ColumnRule())
                .addRule(new BoxRule())
                .updateBoard(cells)
                .build());
            }
            default:
                throw new GameException(ErrorMessage.UNSUPPORTED_GAME_TYPE);
        }
    }
}

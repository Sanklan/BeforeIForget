package com.fortify.solver;

import com.fortify.game.Game;
import com.fortify.game.GameException;
import com.fortify.ErrorMessage;

public class Solver {
    
    public static void sudoku(Game game) throws GameException {
        if (!solve(game, 0, 0)) 
            throw new GameException(ErrorMessage.UNSOLVABLE_BOARD);
    }

    private static boolean solve(Game game, int i, int j) {
        if (i == 9)  return true;
        if (i < 9 && j == 9) return solve(game, i + 1, 0);
        if (!game.getBoard().isEmpty(i, j)) return solve(game, i, j + 1);
        for(int val = 1; val <= 9; val++) {
            if (game.update(i, j, val)) {
                if (solve(game, i, j + 1)) return true;
                game.update(i, j, -1);
            }
        }

        return false;
    }
}

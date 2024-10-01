package com.fortify;

import java.util.List;

import com.fortify.game.GameFactory;
import com.fortify.game.GameType;
import com.fortify.solver.Solver;
import com.fortify.game.Game;
import com.fortify.game.GameException;
public class Main {


    public static void main(String[] args) throws Exception{
        List<int[][]> tests = TestDataReader.readTests(Constant.TEST_FILE);

        for (int[][] cells:tests) {
           try {
            Game game = GameFactory.createGame(GameType.Sudoku,  cells);
            // to convert this input real game, instead of using Solver, use game.update() to update on every user input
            Solver.sudoku(game);
            System.out.println("Solved Sudoku \n" + game.getBoard().toString());

            } catch(GameException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

package com.fortify.game;

import com.fortify.ErrorMessage;
import com.fortify.data.Board;
import com.fortify.rule.IRule;

public class Game {
    private Board board;
    private Validator validator;

    private Game() {
    }

    public boolean update(int row, int col, int value) {
        if (!validator.validateCellUpdate(board, row, col, value))
            return false;
        //update validators
        validator.updateValidators(board, row, col, value);
        board.updateCell(row, col, value);
        return true;
    }

    public Board getBoard() {
        return board;
    }

    public static class Builder {
        private Board board;
        private Validator validator;


        private Builder createBoard() {
            if (board == null) 
                this.board = new Board();
            return this;
        }

        public Builder updateCell(int row, int col, int value) {
            createBoard();
            board.updateCell(row, col, value);
            return this;
        }

        public Builder updateRow(int row, int[] value) {
            createBoard();
            board.updateRow(row, value);
            return this;
        }

        public Builder updateBoard(int[][] cells) {
            createBoard();
            board = new Board(cells);
            return this;
        }

        private Builder createValidator() {
            if (validator == null)
                validator = new Validator();
            return this;
        }

        public Builder addRule(IRule rule) {
            createValidator();
            validator.addValidator(rule);
            return this;  
        }

        public Game build() throws GameException {
            if (board == null || validator == null || !validator.validate(board))
                throw new GameException(ErrorMessage.BOARD_VALIDATION_ERROR);
            
            Game game = new Game();
            game.board = board;
            game.validator = validator;
            return game;
        }
    }

}

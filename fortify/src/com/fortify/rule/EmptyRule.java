package com.fortify.rule;

import com.fortify.data.Board;

public class EmptyRule implements IRule{

    @Override
    public boolean validate(Board board) {
        return true;
    }

    @Override
    public boolean validateCellUpdate(Board board, int x, int y, int value) {
        return value == -1 || board.isEmpty(x, y);
    }

    @Override
    public void updateState(Board board, int x, int y, int value) {
        // no changes required
    }

    @Override
    public String getRuleName() {
        return "Empty Cell rule";
    }
    
}

package com.fortify.rule;

import com.fortify.data.Board;
public interface IRule {
    public boolean validate(Board board);
    public boolean validateCellUpdate(Board board, int x, int y, int value);
    public void updateState(Board board, int x, int y, int value);
    public String getRuleName();
}

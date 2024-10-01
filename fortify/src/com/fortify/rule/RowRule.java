package com.fortify.rule;

import java.util.HashMap;
import java.util.HashSet;

import com.fortify.data.Board;

public class RowRule implements IRule {

    
    HashMap<Integer, HashSet<Integer>> rows;
    public RowRule() {
        rows = new HashMap<Integer, HashSet<Integer>>();
    }

    @Override
    public boolean validate(Board board) {
        rows.clear();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (!board.isEmpty(i, j)) {
                    int index = i;
                    if (rows.containsKey(index)) {
                        if (rows.get(index).contains(board.getCell(i, j))) {
                            return false;
                        } else {
                            rows.get(index).add(board.getCell(i, j));
                        }
                    } else {
                        rows.put(index, new HashSet<Integer>());
                        rows.get(index).add(board.getCell(i, j));
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void updateState(Board board, int x, int y, int value) {
        int index = getIndex(x, y);
        if (value == -1) {
            if (board.getCell(x, y) != -1 && rows.containsKey(index)) 
                rows.get(index).remove(board.getCell(x, y));
        } else {
            if (!rows.containsKey(index)) {
                rows.put(index, new HashSet<Integer>());
            }
            rows.get(index).add(value);
        }
    }

    @Override
    public boolean validateCellUpdate(Board board, int x, int y, int value) {
        int index = getIndex(x, y);
        if (value != -1 && rows.containsKey(index) && rows.get(index).contains(value)) {
           return false;
        }
        return true;
    }

    @Override
    public String getRuleName() {
        return "Repeated number in row Rule";
    }
    
    private int getIndex(int x, int y) {
        return x;
    }
}

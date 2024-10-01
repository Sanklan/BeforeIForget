package com.fortify.game;

import java.util.List;
import java.util.ArrayList;

import com.fortify.data.Board;
import com.fortify.rule.IRule;
public class Validator {
    private List<IRule> rules;

    public Validator() {
        this.rules = new ArrayList<IRule>();
    }

    public Validator addValidator(IRule rule) {
        this.rules.add(rule);
        return this;
    }

    public boolean validate(Board board) {
        for (IRule rule : rules) {
            if (!rule.validate(board)) {
                System.out.println("rule failed: " + rule.getRuleName());
                return false;
            }
        }
        return true;
    }

    public boolean validateCellUpdate(Board board, int row, int col, int value) {
        for (IRule rule : rules) {
            if (!rule.validateCellUpdate(board, row, col, value)) {
                return false;
            }
        }
        return true;
    }

    public void updateValidators(Board board, int row, int col, int value) {
        for (IRule rule : rules)
            rule.updateState(board, row, col, value);
    }
}

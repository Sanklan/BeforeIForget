package com.fortify;

public enum ErrorMessage {
    RULE_VALIDATION_ERROR("Error validating rule", 1),
    
    BOARD_VALIDATION_ERROR("Rule volidated trying to update board", 11),

    UNSUPPORTED_GAME_TYPE("Unsupported game type", 100),
    UNSOLVABLE_BOARD("Unsolvable board", 101);

    private final String message;
    private final int code;
    ErrorMessage(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return "[" + code + "]" + message;
    }
}
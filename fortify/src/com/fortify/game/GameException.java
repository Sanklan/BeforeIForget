package com.fortify.game;

import com.fortify.ErrorMessage;

public class GameException extends Exception {
    public GameException(ErrorMessage message) {
        super(message.toString());
    }
}

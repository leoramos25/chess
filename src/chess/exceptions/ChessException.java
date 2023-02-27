package chess.exceptions;

import boardgame.exceptions.BoardException;

import java.io.Serial;

public class ChessException extends BoardException {
    @Serial
    private static final long serialVersionUID = 8954997655877517208L;

    public ChessException(String message) {
        super(message);
    }
}

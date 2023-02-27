package chess.exceptions;

import java.io.Serial;

public class ChessException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 8954997655877517208L;

    public ChessException(String message) {
        super(message);
    }
}

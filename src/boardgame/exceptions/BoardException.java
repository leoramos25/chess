package boardgame.exceptions;

import java.io.Serial;

public class BoardException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 3562041729316842780L;

    public BoardException(String message) {
        super(message);
    }
}

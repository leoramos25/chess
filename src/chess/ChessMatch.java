package chess;

import boardgame.Board;
import boardgame.Position;
import chess.enums.Color;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] chessPiecesMatrix = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                chessPiecesMatrix[i][j] = (ChessPiece) board.piece(i, j);
            }
        }

        return chessPiecesMatrix;
    }

    private void initialSetup() {
        this.board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
        this.board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
        this.board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
    }
}

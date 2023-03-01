package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.enums.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position piece = new Position(0, 0);

        //above
        piece.setValue(position.getRow() - 1, position.getColumn());

        while (getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
            matrix[piece.getRow()][piece.getColumn()] = true;
            piece.setRow(piece.getRow() - 1);
        }

        if (getBoard().positionExists(position) && isThereOpponentPiece(piece)) {
            matrix[piece.getRow()][piece.getColumn()] = true;
        }

        //left
        piece.setValue(position.getRow(), position.getColumn() - 1);

        while (getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
            matrix[piece.getRow()][piece.getColumn()] = true;
            piece.setColumn(piece.getColumn() - 1);
        }

        if (getBoard().positionExists(position) && isThereOpponentPiece(piece)) {
            matrix[piece.getRow()][piece.getColumn()] = true;
        }

        //left
        piece.setValue(position.getRow(), position.getColumn() + 1);

        while (getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
            matrix[piece.getRow()][piece.getColumn()] = true;
            piece.setColumn(piece.getColumn() + 1);
        }

        if (getBoard().positionExists(position) && isThereOpponentPiece(piece)) {
            matrix[piece.getRow()][piece.getColumn()] = true;
        }

        //bellow
        piece.setValue(position.getRow() + 1, position.getColumn());

        while (getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
            matrix[piece.getRow()][piece.getColumn()] = true;
            piece.setRow(piece.getRow() + 1);
        }

        if (getBoard().positionExists(position) && isThereOpponentPiece(piece)) {
            matrix[piece.getRow()][piece.getColumn()] = true;
        }

        return matrix;
    }
}

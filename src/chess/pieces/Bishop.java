package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.enums.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position piecePosition = new Position(0, 0);

        // nw
        piecePosition.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
        while (getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
            piecePosition.setValues(piecePosition.getRow() - 1, piecePosition.getColumn() - 1);
        }
        if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        // ne
        piecePosition.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        while (getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
            piecePosition.setValues(piecePosition.getRow() - 1, piecePosition.getColumn() + 1);
        }
        if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        // se
        piecePosition.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        while (getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
            piecePosition.setValues(piecePosition.getRow() + 1, piecePosition.getColumn() + 1);
        }
        if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        // sw
        piecePosition.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        while (getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
            piecePosition.setValues(piecePosition.getRow() + 1, piecePosition.getColumn() - 1);
        }
        if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }
        return matrix;
    }

    @Override
    public String toString() {
        return "B";
    }
}

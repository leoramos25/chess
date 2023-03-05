package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.enums.Color;

public class Pawn extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position piecePosition = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            piecePosition.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
                matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
            }

            piecePosition.setValues(position.getRow() - 2, position.getColumn());
            Position piecePosition2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(piecePosition2)
                    && !getBoard().thereIsAPiece(piecePosition2)
                    && getMoveCount() == 0) {
                matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
            }

            piecePosition.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
                matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
            }

            piecePosition.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
                matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
            }
        } else {
            piecePosition.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
                matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
            }

            piecePosition.setValues(position.getRow() + 2, position.getColumn());
            Position piecePosition2 = new Position(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(piecePosition2)
                    && !getBoard().thereIsAPiece(piecePosition2)
                    && getMoveCount() == 0) {
                matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
            }

            piecePosition.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
                matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
            }

            piecePosition.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
                matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
            }
        }
        return matrix;
    }

    @Override
    public String toString() {
        return "P";
    }
}

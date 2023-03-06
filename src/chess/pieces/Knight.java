package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.enums.Color;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position piecePosition = new Position(0, 0);

        piecePosition.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        piecePosition.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        piecePosition.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        piecePosition.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        piecePosition.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        piecePosition.setValues(position.getRow() + 2, position.getColumn() + 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        piecePosition.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        piecePosition.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        return matrix;
    }

    private boolean canMove(Position position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    @Override
    public String toString() {
        return "N";
    }
}

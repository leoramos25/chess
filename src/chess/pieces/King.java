package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.enums.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position piecePosition = new Position(0, 0);

        // above
        piecePosition.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        // below
        piecePosition.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        // left
        piecePosition.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        // right
        piecePosition.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        // nw
        piecePosition.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        // ne
        piecePosition.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        // sw
        piecePosition.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        // se
        piecePosition.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(piecePosition) && canMove(piecePosition)) {
            matrix[piecePosition.getRow()][piecePosition.getColumn()] = true;
        }

        return matrix;
    }

    private boolean canMove(Position position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }
}

package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.enums.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean canMove(Position position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
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

        // special move castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // kingside rook
            Position rightRookPosition = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(rightRookPosition)) {
                Position rightKingPositionPlusOne = new Position(position.getRow(), position.getColumn() + 1);
                Position rightKingPositionPlusTwo = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(rightKingPositionPlusOne) == null
                        && getBoard().piece(rightKingPositionPlusTwo) == null) {
                    matrix[position.getRow()][position.getColumn() + 2] = true;
                }

            }

            // queenside rook
            Position leftRookPosition = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(leftRookPosition)) {
                Position rightKingPositionMinusOne = new Position(position.getRow(), position.getColumn() - 1);
                Position rightKingPositionMinusTwo = new Position(position.getRow(), position.getColumn() - 2);
                Position rightKingPositionMinusTree = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(rightKingPositionMinusOne) == null
                        && getBoard().piece(rightKingPositionMinusTwo) == null
                        && getBoard().piece(rightKingPositionMinusTree) == null) {
                    matrix[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return matrix;
    }
}

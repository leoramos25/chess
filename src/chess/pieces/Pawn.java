package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.enums.Color;

public class Pawn extends ChessPiece {
    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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

            if (position.getRow() == 3) {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left)
                        && isThereOpponentPiece(left)
                        && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    matrix[left.getRow() - 1][left.getColumn()] = true;
                }
            }

            if (position.getRow() == 3) {
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(right)
                        && isThereOpponentPiece(right)
                        && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    matrix[right.getRow() - 1][right.getColumn()] = true;
                }
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

            if (position.getRow() == 4) {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left)
                        && isThereOpponentPiece(left)
                        && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    matrix[left.getRow() + 1][left.getColumn()] = true;
                }
            }

            if (position.getRow() == 4) {
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(right)
                        && isThereOpponentPiece(right)
                        && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    matrix[right.getRow() + 1][right.getColumn()] = true;
                }
            }
        }
        return matrix;
    }

    @Override
    public String toString() {
        return "P";
    }
}

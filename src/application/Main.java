package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.exceptions.ChessException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessMatch match = new ChessMatch();
        List<ChessPiece> capturedPieces = new ArrayList<>();

        while (!match.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(match, capturedPieces);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(scanner);

                boolean[][] possibleMoves = match.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(match.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(scanner);

                ChessPiece capturedPiece = match.performChessMove(source, target);

                if (capturedPiece != null) {
                    capturedPieces.add(capturedPiece);
                }
            } catch (ChessException | InputMismatchException exception) {
                System.out.println(exception.getMessage());
                scanner.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(match, capturedPieces);
    }
}
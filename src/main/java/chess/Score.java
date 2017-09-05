package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;

public class Score {
    Board board;
    public Score(Board board) {
        this.board = board;
    }
    
    public double getWhiteScore() {
        return getScore(Color.WHITE);
    }
    public double getBlackScore() {
        return getScore(Color.BLACK);
    }
    double getScore(Color color) {
        double score = 0.0;
        score += getPawnScore(color);
        score += getRookScore(color);
        score += getKnightScore(color);
        score += getBishopScore(color);
        score += getQueenScore(color);
        return score;
    }
    
    Color getWinner() {
        if (getBlackScore() > getWhiteScore()) return Color.BLACK;
        return Color.WHITE;
    }
    
    private double getPawnScore(Color color) {
        return 1.0 * board.getPieceCount(color, Piece.Type.PAWN);
    }
    private double getRookScore(Color color) {
        return 5.0 * board.getPieceCount(color, Piece.Type.ROOK);
    }
    private double getKnightScore(Color color) {
        return 2.5 * board.getPieceCount(color, Piece.Type.KNIGHT);
    }
    private double getBishopScore(Color color) {
        return 3.0 * board.getPieceCount(color, Piece.Type.BISHOP);
    }
    private double getQueenScore(Color color) {
        return 9.0 * board.getPieceCount(color, Piece.Type.QUEEN);
    }
}

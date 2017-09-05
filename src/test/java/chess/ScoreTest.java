package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.pieces.King;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class ScoreTest {
    Board board;
    Position position;
    @Before
    public void setup() {
        board = new Board();
    }
    
    @Test
    public void whiteScore() {
        board.initialize();
        System.out.println(board.showBoard());
        Score score = new Score(board);
        assertEquals(38.0, score.getScore(Piece.Color.WHITE), 0.01);
    }
    
    @Test
    public void caculcatePoint() throws Exception {
        board.blankBoard();
        Score score = new Score(board);
        
        addPiece("b6", Pawn.createBlackPawn("b6"));
        addPiece("e6", Queen.createBlackQueen("e6"));
        addPiece("b8", King.createBlackKing("b8"));
        addPiece("c8", Rook.createBlackRook("c8"));

        addPiece("f2", Pawn.createWhitePawn("f2"));
        addPiece("g2", Pawn.createWhitePawn("g2"));
        addPiece("e1", Rook.createWhiteRook("e1"));
        addPiece("f1", King.createWhiteKing("f1"));

        assertEquals(15.0, score.getScore(Piece.Color.BLACK), 0.01);
        assertEquals(7.0, score.getScore(Piece.Color.WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    private void addPiece(String target, Piece piece) {
        board.generatePiece(target, piece);
    }
}

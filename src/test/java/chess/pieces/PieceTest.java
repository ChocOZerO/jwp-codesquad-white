package chess.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Board;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;

public class PieceTest {
    
    @Test
    public void getRepresentationPerPiece() throws Exception {
        assertEquals('p', Piece.Type.PAWN.getWhiteRepresentation());
        assertEquals('P', Piece.Type.PAWN.getBlackRepresentation());
    }
    
    @Test
    public void create_piece() {
        verifyPiece(Pawn.createWhitePawn("a1"), Pawn.createBlackPawn("a1"), Type.PAWN);
        verifyPiece(Knight.createWhiteKnight("a1"), Knight.createBlackKnight("a1"), Type.KNIGHT);
        verifyPiece(Rook.createWhiteRook("a1"), Rook.createBlackRook("a1"), Type.ROOK);
        verifyPiece(Bishop.createWhiteBishop("a1"), Bishop.createBlackBishop("a1"), Type.BISHOP);
        verifyPiece(Queen.createWhiteQueen("a1"), Queen.createBlackQueen("a1"), Type.QUEEN);
        verifyPiece(King.createWhiteKing("a1"), King.createBlackKing("a1"), Type.KING);

        Piece blank = Blank.createBlank("a1");
        assertFalse(blank.isWhite());
        assertFalse(blank.isBlack());
        assertEquals(Type.NO_PIECE, blank.getType());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
    }
    
    @Test
    public void isWhiteAndBlack() throws Exception {
        assertTrue(Pawn.createWhitePawn("a1").isWhite());
        assertTrue(Rook.createWhiteRook("a1").isWhite());
        assertTrue(Knight.createWhiteKnight("a1").isWhite());
        assertTrue(Bishop.createWhiteBishop("a1").isWhite());
        assertTrue(Queen.createWhiteQueen("a1").isWhite());
        assertTrue(King.createWhiteKing("a1").isWhite());
        
        assertTrue(Pawn.createBlackPawn("a1").isBlack());
        assertTrue(Rook.createBlackRook("a1").isBlack());
        assertTrue(Knight.createBlackKnight("a1").isBlack());
        assertTrue(Bishop.createBlackBishop("a1").isBlack());
        assertTrue(Queen.createBlackQueen("a1").isBlack());
        assertTrue(King.createBlackKing("a1").isBlack());
    }
    
    @Test
    public void checkSamePiece() {
        assertTrue(Pawn.createWhitePawn("a1").checkSamePiece(Color.WHITE, Type.PAWN));
    }
    
    @Test
    public void Score() {
        System.out.println(Piece.Type.ROOK.getScore());
    }
    
    @Test
    public void getPosition() {
        Board board = new Board();
        board.initialize();
        assertEquals("c7", Knight.createBlackKnight("c7").getPosition());
    }
    
}

package chess;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.pieces.Bishop;
import chess.pieces.Blank;
import chess.pieces.Piece;

public class RankTest {

    @Test
    public void testBlankRank() {
        Rank rank = new Rank(0);
        
        assertEquals(Blank.createBlank("a8"), rank.getPiece(0));
        assertEquals(8, rank.getRank().size());
    }
    
    @Test
    public void testRank() {
        Rank rank = new Rank(0);
        rank.setPiece(0, Bishop.createBlackBishop("a8"));
        assertEquals('B', rank.getPiece(0).getRepresentation());
        assertEquals(Piece.Color.BLACK, rank.getPiece(0).getColor());
        assertEquals(Piece.Type.BISHOP, rank.getPiece(0).getType());
    }
    
    @Test
    public void countPiece() {
        Rank rank = new Rank(0);
        rank.setPiece(0, Bishop.createBlackBishop("a8"));
        rank.setPiece(3, Bishop.createBlackBishop("d8"));
        assertEquals(2, rank.countPiece(Piece.Color.BLACK, Piece.Type.BISHOP));
    }
    
    @Test
    public void chceckRankRepresentation() {
        Rank rank = new Rank(0);
        assertEquals("........", rank.getRankRepresentation());
    }
}

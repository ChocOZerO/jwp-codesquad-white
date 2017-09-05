package chess;

import static org.junit.Assert.*;
import static utils.StringUtils.*;

import org.junit.Before;
import org.junit.Test;

import chess.pieces.Bishop;
import chess.pieces.Blank;
import chess.pieces.Knight;
import chess.pieces.Piece;
import chess.pieces.Rook;

public class BoardTest {
    
    private Board board;
    Position position;
    
    @Before
    public void setup() {
        board = new Board();
    }
    
    @Test
    public void create() {
        board.initialize();
        assertEquals(32, board.countTotalPiece());
        String blankLine = appendNewLine(getBlankLine());
        assertEquals(
            appendNewLine("RNBQKBNR") +
            appendNewLine("PPPPPPPP") +
            blankLine + blankLine + blankLine + blankLine +
            appendNewLine("pppppppp") +
            appendNewLine("rnbqkbnr"),
            board.showBoard());
    }
    
    @Test
    public void print() throws Exception {
        board.initialize();
        System.out.println(board.showBoard());
        assertEquals(2, board.getPieceCount(Piece.Color.WHITE, Piece.Type.KNIGHT));
    }
    
    @Test
    public void pieceCount() throws Exception {
        board.blankBoard();
        assertEquals(64, board.getPieceCount(Piece.Color.NO_COLOR, Piece.Type.NO_PIECE));
        
    }
    
    @Test
    public void chceckBlankBoardRepresentation() {
        board.blankBoard();
        String blankLine = appendNewLine(getBlankLine());
        assertEquals(blankLine + blankLine
                + blankLine + blankLine
                + blankLine + blankLine
                + blankLine + blankLine, board.showBoard());
    }
    
    @Test
    public void position() {
        board.initialize();
        assertEquals(Bishop.createBlackBishop("f8"), board.findPiece("f8"));
        assertEquals(Blank.createBlank("f4"), board.findPiece("f4"));
        assertEquals(Rook.createWhiteRook("a1"), board.findPiece("a1"));
    }
    
    @Test
    public void generate() throws Exception {
        board.blankBoard();
        
        String target = "b5";
        Piece piece = Rook.createBlackRook("b5");
        
        board.generatePiece(target, piece);

        assertEquals(piece, board.findPiece(target));
        System.out.println(board.showBoard());
    }
    
    @Test
    public void moveNotAvailable() throws Exception {
        board.initialize();
        
        String target = "c3";
        String order = "b1";
        Piece piece = board.findPiece(order); 
        assertEquals(Knight.createWhiteKnight(order), piece);
        board.move(order , target);

        assertEquals(piece, board.findPiece(target));
        System.out.println(board.showBoard());
    }
    @Test
    public void moveAvailable() throws Exception {
        board.initialize();
        
        String target = "a5";
        String order = "a1";
        Piece piece = board.findPiece(order); 
        assertEquals(Rook.createWhiteRook(order), piece);
        board.move(order , target);

        assertEquals(piece, board.findPiece(target));
        System.out.println(board.showBoard());
    }
    
    @Test
    public void moveToSameTeam() throws Exception {
        board.initialize();
        
        String target = "a2";
        String order = "a1";
//        Piece piece = board.findPiece(order); 
//        assertEquals(Rook.createWhiteRook(order), piece);
        board.move(order , target); // 같은 편이 있는 자리입니다.

//        assertEquals(piece, board.findPiece(order));
        System.out.println(board.showBoard());
    }
    
}

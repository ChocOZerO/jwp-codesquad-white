package chess;

import java.util.ArrayList;
import java.util.List;

import chess.pieces.Bishop;
import chess.pieces.Blank;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class Rank {
    
    private List<Piece> rank = new ArrayList<>();
    private int rankNum;
    
    Rank(int rankNum) {
        setBlankRank();
        this.rankNum = 8 - rankNum;
    }
    
    public void setPiece(int index, Piece piece) {
        this.rank.set(index, piece);
    }
    public Piece getPiece(int index) {
        return this.rank.get(index);
    }
    
    int getRankNum() {
        return this.rankNum;
    }
    private void setBlankRank() {
        for (int i = 0; i < 8; i++) {
            this.rank.add(Blank.createBlank(String.valueOf((char)(97+i)) + this.rankNum));
        }
    }
    public List<Piece> getBlankRank() {
        for (int i = 0; i < 8; i++) { 
            this.rank.set(i, Blank.createBlank(String.valueOf((char)(97+i)) + this.rankNum));
        }
        return this.rank;
    }
    
    public List<Piece> initializeWhitePawnRank() {
        for (int i = 0; i < 8; i++) { 
            this.rank.set(i, Pawn.createWhitePawn(String.valueOf((char)(97+i)) + this.rankNum));
        }
        return this.rank;
    }
    public List<Piece> initializeWhitePieceRank() {
        this.rank.set(0, Rook.createWhiteRook(String.valueOf((char)(97+0)) + this.rankNum));
        this.rank.set(1, Knight.createWhiteKnight(String.valueOf((char)(97+1)) + this.rankNum));
        this.rank.set(2, Bishop.createWhiteBishop(String.valueOf((char)(97+2)) + this.rankNum));
        this.rank.set(3, Queen.createWhiteQueen(String.valueOf((char)(97+3)) + this.rankNum));
        this.rank.set(4, King.createWhiteKing(String.valueOf((char)(97+4)) + this.rankNum));
        this.rank.set(5, Bishop.createWhiteBishop(String.valueOf((char)(97+5)) + this.rankNum));
        this.rank.set(6, Knight.createWhiteKnight(String.valueOf((char)(97+6)) + this.rankNum));
        this.rank.set(7, Rook.createWhiteRook(String.valueOf((char)(97+7)) + this.rankNum));
        return this.rank;
    }
    public List<Piece> initializeBlackPawnRank() {
        for (int i = 0; i < 8; i++) { 
            this.rank.set(i, Pawn.createBlackPawn(String.valueOf((char)(97+i)) + this.rankNum));
        }
        return this.rank;
    }
    public List<Piece> initializeBlackPieceRank() {
        this.rank.set(0, Rook.createBlackRook(String.valueOf((char)(97+0)) + this.rankNum));
        this.rank.set(1, Knight.createBlackKnight(String.valueOf((char)(97+1)) + this.rankNum));
        this.rank.set(2, Bishop.createBlackBishop(String.valueOf((char)(97+2)) + this.rankNum));
        this.rank.set(3, Queen.createBlackQueen(String.valueOf((char)(97+3)) + this.rankNum));
        this.rank.set(4, King.createBlackKing(String.valueOf((char)(97+4)) + this.rankNum));
        this.rank.set(5, Bishop.createBlackBishop(String.valueOf((char)(97+5)) + this.rankNum));
        this.rank.set(6, Knight.createBlackKnight(String.valueOf((char)(97+6)) + this.rankNum));
        this.rank.set(7, Rook.createBlackRook(String.valueOf((char)(97+7)) + this.rankNum));
        return this.rank;
    }
    
    public List<Piece> getRank() {
        return this.rank;
    }
    int countPiece(Color color, Type type) {
        int pieceCount = 0;
        for (Piece piece: this.rank) {
            if (piece.checkSamePiece(color, type)) {
                pieceCount++;
            }
        }
        return pieceCount;
    }
    String getRankRepresentation() {
        StringBuilder sb = new StringBuilder();
        for (Piece piece: this.rank) {
            sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }
}

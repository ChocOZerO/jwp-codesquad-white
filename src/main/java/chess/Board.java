package chess;

import java.util.ArrayList;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;

public class Board {
    
    ArrayList<Rank> board = new ArrayList<>();
    Position position;
    public Board() {
        for (int i = 0; i < 8; i++) {
            this.board.add(new Rank(i));
        }
        position = new Position(this);
    }
    
    int getPieceCount(Color color, Type type) {
        int pieceCount = 0;
        for (Rank rank : this.board) {
            pieceCount += rank.countPiece(color, type);
        }
        return pieceCount;
    }
    
    public ArrayList<Rank> getBoard() {
        return this.board;
    }
    public Rank getRank(int index) {
        return this.board.get(index);
    }
    
    private int countBlank() {
        int blankCount = 0;
        for (Rank rank: this.board) {
            blankCount += rank.countPiece(Color.NO_COLOR, Type.NO_PIECE);
        }
        return blankCount;
    }
    int countTotalPiece() {
        return 64 - countBlank();
    }
    
    public void blankBoard() {
        for (int i = 0; i < this.board.size(); i++) {
            board.set(i, new Rank(i));
        }
    }
    public void initialize() {
        this.board.get(0).initializeBlackPieceRank();
        this.board.get(1).initializeBlackPawnRank();
        for (int i = 2; i <= 5; i++) {
            this.board.get(i).getBlankRank();
        }
        this.board.get(6).initializeWhitePawnRank();
        this.board.get(7).initializeWhitePieceRank();
    }
    
    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank: board) {
            sb.append(rank.getRankRepresentation() + "\n");
        }
        return sb.toString();
    }
    
    public Piece findPiece(String target) {
        return position.findPiece(target);
    }
    
    void generatePiece(String target, Piece piece) {
        this.position.replacePiece(target, piece);
    }
    public void move(String startPosition, String endPosition) {
        this.position.move(startPosition, endPosition);
    }
    
}

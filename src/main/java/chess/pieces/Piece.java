package chess.pieces;

import java.util.ArrayList;
import java.util.List;

import chess.Board;

public abstract class Piece {
    
    public enum Color {
        WHITE, BLACK, NO_COLOR;
    }
    public enum Type {
        PAWN('p', 1.0), KNIGHT('n', 2.5), ROOK('r', 5.0), BISHOP('b', 3.0), QUEEN('q', 9.0), KING('k', 0.0), NO_PIECE('.', 0.0);
        private final char representation;
        private double score;
        Type(char representation, double score) {
            this.representation = representation;
            this.score = score;
        }
        public char getWhiteRepresentation() {
            return this.representation;
        }
        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }
        public double getScore() {
            return this.score;
        }
    }
    
    private Color color;
    private Type type;
    private String position;
    
    List<String> moveAvailable = new ArrayList<>();
    
    public int getXPosition() {
        return this.position.charAt(0) - 'a';
    }
    public int getYPosition() {
        return Character.getNumericValue(this.position.charAt(1));
    }
    
    protected Piece(Color color, Type type, String position) {
        this.color = color;
        this.type = type;
        this.position = position;
    }
    
    public boolean checkMoveAvailable(Board board, String target) {
        setMoveAvailable(board);
        if (this.moveAvailable.size() < 1) return false;
        for (String moveTarget: this.moveAvailable) {
            if (moveTarget.equals(target)) return true;
        }
        return false;
    }
    
    protected abstract void setMoveAvailable(Board board);
    
    public List<String> getMoveAvailable() {
        return this.moveAvailable;
    }
    
    protected boolean isPieceBarrier(Board board, String target) {
        if (!board.findPiece(target).getType().equals(Piece.Type.NO_PIECE)) {
            return true;
        }
        return false;
    }
    protected boolean isPositionAvailable(Board board, String position) {
        int x = position.charAt(0) - 'a';
        int y = 8 - Integer.parseInt(position.substring(1));
        
        if (x < 0 || x > 7) return false;
        if (y < 0 || y > 7 ) return false;
        if (this.checkSameTeam(board.findPiece(position))) return false;
        return true;
    }
    
    public Color getColor() {
        return this.color;
    }
    public Type getType() {
        return this.type;
    }
    public char getRepresentation() {
        if (this.isBlack()) {
            return this.type.getBlackRepresentation();
        }
        return this.type.getWhiteRepresentation();
    }
    public String getPosition() {
        return this.position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    
    public boolean checkSamePiece(Color color, Type type) {
        return (this.color.equals(color) && this.type.equals(type));
    }
    public boolean checkSameTeam(Piece target) {
        return this.color.equals(target.color);
    }
    
    public String getSymbol() {
        return isWhite() ? getWhiteSymbol() : getBlackSymbol();
    }
    protected abstract String getWhiteSymbol();
    protected abstract String getBlackSymbol();
    
    public boolean isWhite() {
        return this.color.equals(Color.WHITE);
    }
    public boolean isBlack() {
        return this.color.equals(Color.BLACK);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Piece other = (Piece) obj;
        if (color != other.color)
            return false;
        if (type != other.type)
            return false;
        return true;
    }
}

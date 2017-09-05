package chess.pieces;

import chess.Board;

public class Rook extends Piece {
    
    private Rook(Color color, Type type, String position) {
        super(color, type, position);
    }
    public static Piece createWhiteRook(String position) {
        return new Rook(Color.WHITE, Type.ROOK, position);
    }
    public static Piece createBlackRook(String position) {
        return new Rook(Color.BLACK, Type.ROOK, position);
    }
    
    @Override
    protected void setMoveAvailable(Board board) {
        
        String availablePosition = "";
        for (int i = 1; i <= 7; i++) {
            availablePosition = String.valueOf((char)(97+this.getXPosition())) + (this.getYPosition()+i);
            if (addMoveAvailable(board, availablePosition)) break;
        }
        for (int i = 1; i <= 7; i++) {
            availablePosition = String.valueOf((char)(97+this.getXPosition()+i)) + (this.getYPosition());
            if (addMoveAvailable(board, availablePosition)) break;
        }
        for (int i = 1; i <= 7; i++) {
            availablePosition = String.valueOf((char)(97+this.getXPosition())) + (this.getYPosition()-i);
            if (addMoveAvailable(board, availablePosition)) break;
        }
        for (int i = 1; i <= 7; i++) {
            availablePosition = String.valueOf((char)(97+this.getXPosition()-i)) + (this.getYPosition());
            if (addMoveAvailable(board, availablePosition)) break;
        }
    }
    
    private boolean addMoveAvailable(Board board, String availablePosition) {
        if (isPositionAvailable(board, availablePosition)) {
            this.moveAvailable.add(availablePosition);
            if (isPieceBarrier(board, availablePosition)) return true;
        }
        return false;
    }
    
    @Override
    protected String getWhiteSymbol() {
        return "&#9814;";
    }

    @Override
    protected String getBlackSymbol() {
        return "&#9820;";
    }
}

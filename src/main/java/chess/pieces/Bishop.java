package chess.pieces;

import chess.Board;

public class Bishop extends Piece {
    
    private Bishop(Color color, Type type, String position) {
        super(color, type, position);
    }
    public static Piece createWhiteBishop(String position) {
        return new Bishop(Color.WHITE, Type.BISHOP, position);
    }
    public static Piece createBlackBishop(String position) {
        return new Bishop(Color.BLACK, Type.BISHOP, position);
    }
    
    @Override
    protected void setMoveAvailable(Board board) {
        
        String availablePosition = "";
        
        for (int i = 1; i <= 7; i++) { // positionRightUp
            availablePosition = String.valueOf((char)(97+this.getXPosition()+i)) + (this.getYPosition()+i);
            if (addMoveAvailable(board, availablePosition)) break;
        }
        for (int i = 1; i <= 7; i++) { // positionRightDown
            availablePosition = String.valueOf((char)(97+this.getXPosition()+i)) + (this.getYPosition()-i);
            if (addMoveAvailable(board, availablePosition)) break;
        }
        for (int i = 1; i <= 7; i++) { // positionLeftDown
            availablePosition = String.valueOf((char)(97+this.getXPosition()-i)) + (this.getYPosition()-i);
            if (addMoveAvailable(board, availablePosition)) break;
        }
        for (int i = 1; i <= 7; i++) { // positionLeftUp
            availablePosition = String.valueOf((char)(97+this.getXPosition()-i)) + (this.getYPosition()+i);
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
        return "&#9815;";
    }

    @Override
    protected String getBlackSymbol() {
        return "&#9821;";
    }
    
}

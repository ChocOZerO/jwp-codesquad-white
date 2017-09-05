package chess.pieces;

import chess.Board;

public class Queen extends Piece {
    
    private Queen(Color color, Type type, String position) {
        super(color, type, position);
    }
    public static Piece createWhiteQueen(String position) {
        return new Queen(Color.WHITE, Type.QUEEN, position);
    }
    public static Piece createBlackQueen(String position) {
        return new Queen(Color.BLACK, Type.QUEEN, position);
    }
    
    @Override
    protected void setMoveAvailable(Board board) {
        
        String availablePosition = "";
        
        for (int i = 1; i <= 7; i++) { // positionUp
            availablePosition = String.valueOf((char)(97+this.getXPosition())) + (this.getYPosition()+i);
            if (addMoveAvailable(board, availablePosition)) break;
        }
        for (int i = 1; i <= 7; i++) { // positionRightUp
            availablePosition = String.valueOf((char)(97+this.getXPosition()+i)) + (this.getYPosition()+i);
            if (addMoveAvailable(board, availablePosition)) break;
        }
        for (int i = 1; i <= 7; i++) { // positionRight
            availablePosition = String.valueOf((char)(97+this.getXPosition()+i)) + (this.getYPosition());
            if (addMoveAvailable(board, availablePosition)) break;
        }
        for (int i = 1; i <= 7; i++) { // positionRightDown
            availablePosition = String.valueOf((char)(97+this.getXPosition()+i)) + (this.getYPosition()-i);
            if (addMoveAvailable(board, availablePosition)) break;
        }
        for (int i = 1; i <= 7; i++) { // positionDown
            availablePosition = String.valueOf((char)(97+this.getXPosition())) + (this.getYPosition()-i);
            if (addMoveAvailable(board, availablePosition)) break;
        }
        for (int i = 1; i <= 7; i++) { // positionLeftDown
            availablePosition = String.valueOf((char)(97+this.getXPosition()-i)) + (this.getYPosition()-i);
            if (addMoveAvailable(board, availablePosition)) break;
        }
        for (int i = 1; i <= 7; i++) { // positionLeft
            availablePosition = String.valueOf((char)(97+this.getXPosition()-i)) + (this.getYPosition());
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
        return "&#9813;";
    }

    @Override
    protected String getBlackSymbol() {
        return "&#9819;";
    }
    
}

package chess.pieces;

import chess.Board;

public class King extends Piece {
    
    private King(Color color, Type type, String position) {
        super(color, type, position);
    }
    public static Piece createWhiteKing(String position) {
        return new King(Color.WHITE, Type.KING, position);
    }
    public static Piece createBlackKing(String position) {
        return new King(Color.BLACK, Type.KING, position);
    }
    
    @Override
    protected void setMoveAvailable(Board board) {
        // 시계방향으로 8가지 방향
        //1
        String availablePosition = String.valueOf((char)(97+this.getXPosition())) + (this.getYPosition()+1);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //2
        availablePosition = String.valueOf((char)(97+this.getXPosition()+1)) + (this.getYPosition()+1);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //3
        availablePosition = String.valueOf((char)(97+this.getXPosition()+1)) + (this.getYPosition());
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //4
        availablePosition = String.valueOf((char)(97+this.getXPosition()+1)) + (this.getYPosition()-1);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //5
        availablePosition = String.valueOf((char)(97+this.getXPosition())) + (this.getYPosition()-1);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //6
        availablePosition = String.valueOf((char)(97+this.getXPosition()-1)) + (this.getYPosition()-1);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //7
        availablePosition = String.valueOf((char)(97+this.getXPosition()-1)) + (this.getYPosition());
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //8
        availablePosition = String.valueOf((char)(97+this.getXPosition()-1)) + (this.getYPosition()+1);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
    }
    
    @Override
    protected String getWhiteSymbol() {
        return "&#9812;";
    }

    @Override
    protected String getBlackSymbol() {
        return "&#9818;";
    }
    
}

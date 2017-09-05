package chess.pieces;

import chess.Board;

public class Knight extends Piece {
    
    private Knight(Color color, Type type, String position) {
        super(color, type, position);
    }
    public static Piece createWhiteKnight(String position) {
        return new Knight(Color.WHITE, Type.KNIGHT, position);
    }
    public static Piece createBlackKnight(String position) {
        return new Knight(Color.BLACK, Type.KNIGHT, position);
    }
    
    @Override
    protected void setMoveAvailable(Board board) {
        // 시계방향으로 8가지 방향
        //1
        String availablePosition = String.valueOf((char)(97+this.getXPosition()+1)) + (this.getYPosition()+2);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //2
        availablePosition = String.valueOf((char)(97+this.getXPosition()+1)) + (this.getYPosition()-2);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //3
        availablePosition = String.valueOf((char)(97+this.getXPosition()+2)) + (this.getYPosition()+1);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //4
        availablePosition = String.valueOf((char)(97+this.getXPosition()+2)) + (this.getYPosition()-1);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //5
        availablePosition = String.valueOf((char)(97+this.getXPosition()-1)) + (this.getYPosition()+2);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //6
        availablePosition = String.valueOf((char)(97+this.getXPosition()-1)) + (this.getYPosition()-2);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //7
        availablePosition = String.valueOf((char)(97+this.getXPosition()-2)) + (this.getYPosition()+1);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
        //8
        availablePosition = String.valueOf((char)(97+this.getXPosition()-2)) + (this.getYPosition()-1);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
    }
    
    @Override
    protected String getWhiteSymbol() {
        return "&#9816;";
    }

    @Override
    protected String getBlackSymbol() {
        return "&#9822;";
    }
    
}

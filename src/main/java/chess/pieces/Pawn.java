package chess.pieces;

import chess.Board;

public class Pawn extends Piece {
    
    private Pawn(Color color, Type type, String position) {
        super(color, type, position);
    }
    public static Piece createWhitePawn(String position) {
        return new Pawn(Color.WHITE, Type.PAWN, position);
    }
    public static Piece createBlackPawn(String position) {
        return new Pawn(Color.BLACK, Type.PAWN, position);
    }
    
    @Override
    protected void setMoveAvailable(Board board) {
        if (this.isBlack()) setMoveBlackAvailable(board);
        setMoveWhiteAvailable(board);
    }
    private void setMoveBlackAvailable(Board board){
        String availablePosition = String.valueOf((char)(97+this.getXPosition())) + (this.getYPosition()-1);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
    }
    private void setMoveWhiteAvailable(Board board){
        String availablePosition = String.valueOf((char)(97+this.getXPosition())) + (this.getYPosition()+1);
        if (isPositionAvailable(board, availablePosition)) this.moveAvailable.add(availablePosition);
    }
    
    @Override
    protected String getWhiteSymbol() {
        return "&#9817;";
    }

    @Override
    protected String getBlackSymbol() {
        return "&#9823;";
    }
}

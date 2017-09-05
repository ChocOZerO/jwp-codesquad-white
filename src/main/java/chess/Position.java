package chess;

import chess.pieces.Blank;
import chess.pieces.InvalidTargetPosition;
import chess.pieces.Piece;

public class Position {
    
    Board board;
    public Position(Board board) {
        this.board = board;
    }
    
    Piece findPiece(String position) {
        if (position.length() != 2) throw new InvalidTargetPosition("위치는 알파벳1자리+숫자1자리 총 2자리만 가능합니다.");
        return this.board.getRank(getYPosition(position)).getPiece(getXPosition(position));
    }
    private int getXPosition(String position) {
        int x = position.charAt(0) - 'a';
        if (x < 0 || x > 7) throw new InvalidTargetPosition("x 좌표는 a~h만 유효합니다.");
        return x;
    }
    private int getYPosition(String position) {
        int y = 8 - Character.getNumericValue(position.charAt(1));
        if (y < 0 || y > 7 ) throw new InvalidTargetPosition("y 좌표는 1~8만 유효합니다.");
        return y;
    }
    
    void replacePiece(String position, Piece piece) {
        this.board.getRank(getYPosition(position)).setPiece(getXPosition(position), piece);
        piece.setPosition(position);
    }
    void move(String startPosition, String endPosition) {
        if (startPosition == null ) throw new InvalidTargetPosition("시작 위치를 확인해주세요.");
        
        Piece targetPiece = board.findPiece(endPosition);
        Piece orderPiece = board.findPiece(startPosition);
        
        if (orderPiece.checkSameTeam(targetPiece)) throw new InvalidTargetPosition("같은 편이 있는 자리 입니다.");
        if (!orderPiece.checkMoveAvailable(board, endPosition)) throw new InvalidTargetPosition("불가능한 위치 입니다. 가능한 위치 : " + orderPiece.getMoveAvailable());
        replacePiece(endPosition, orderPiece);
        replacePiece(startPosition, Blank.createBlank(startPosition));
    }
    
}

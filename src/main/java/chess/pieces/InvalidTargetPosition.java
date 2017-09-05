package chess.pieces;

public class InvalidTargetPosition extends RuntimeException {
    private static final long serialVersionUID = -2262018355736231053L;

    public InvalidTargetPosition(String message) {
        super(message);
    }
}

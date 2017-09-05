package chocozero.codesquad.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import chess.Board;
import chess.Score;
import chess.pieces.InvalidTargetPosition;
import chess.pieces.Piece.Color;

@Controller
@RequestMapping("/chess")
public class ChessController {
    Board board;
    Score score;
    Color turnColor;
    
    @GetMapping("")
    public String home(Model model) {
        board = new Board();
        score = new Score(board);
        board.initialize();
        turnColor = Color.WHITE;
        model.addAttribute("board", board);
        model.addAttribute("score", score);
        model.addAttribute("turnColor", turnColor);
        return "chess/chessboard";
    }
    
    @PostMapping("/move")
    public String move(String order, String target, Model model) {
        try {
            if (!board.findPiece(order).getColor().equals(turnColor)) throw new InvalidTargetPosition("상태팀 차례입니다.");
            board.move(order, target);
            turnColor = turnColor == Color.WHITE ? Color.BLACK : Color.WHITE;
        } catch (InvalidTargetPosition e) {
            model.addAttribute("err", e.getMessage());
        }
        model.addAttribute("board", board);
        model.addAttribute("score", score);
        model.addAttribute("turnColor", turnColor);
        return "chess/chessboard";
    }
    
    @GetMapping("/reset")
    public String reset() {
        return "redirect:/chess";
    }
    
}

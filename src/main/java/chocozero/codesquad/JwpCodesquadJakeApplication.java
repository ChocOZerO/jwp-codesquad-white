package chocozero.codesquad;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import baseball.Baseball;

@SpringBootApplication
public class JwpCodesquadJakeApplication {
	public static final ArrayList<Integer> COMPUTER_BALLS = Baseball.generateComputerBalls();;
	public static ArrayList<ArrayList> userBallsList = new ArrayList<>();
    public static void main(String[] args) {
        SpringApplication.run(JwpCodesquadJakeApplication.class, args);
    }
}

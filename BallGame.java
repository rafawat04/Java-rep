import java.util.*;

public class BallGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] balls = new int[100];
        int count = 0;

        for (int i = 0; i < balls.length; i++) {
            balls[i] = i;

        }
        for (int i = 0; i < balls.length; i++) {
            int idx = rand.nextInt(balls.length - i) + i;
            int temp = balls[i];
            balls[i] = balls[idx];
            balls[idx] = temp;
        }

        int winA = 0;
        int winB = 0;

        do {
            System.out.println((count + 1) + "回目");
            System.out.print("A:" + balls[count * 2]);
            System.out.print("B:" + balls[count * 2 + 1]);
            System.out.println(balls[count * 2] > balls[count * 2 + 1] ? "Aの勝ち" : "Bの勝ち");

            if (balls[count * 2] > balls[count * 2 + 1]) {
                winA++;
            } else {
                winB++;
            }
            count++;
        } while (count < 5);
        System.out.println(winA > winB ? winA + "対" + winB + "でAの勝ち" : winB + "対" + winA + "でBの勝ち");

    }

}

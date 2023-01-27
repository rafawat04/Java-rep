
import java.util.*;

public class BallAppShuffle {
  public static void main(String[] args) {

    Random rand = new Random();
    int[] balls = { 1, 2, 3, 4, 5 };

    // Shuffle algorithm
    for (int i = 0; i < balls.length - 1; i++) { // balls.length - 1 is because the LAST NUMBER dont need to be
                                                 // shuffle(smart code)
      int idx = rand.nextInt(balls.length - i) + i; // length -i is because we want cut 1 Array( 0 ~), +i is because we
                                                    // need to forget the the first Array(0) and go to the next
      int temp = balls[idx];
      balls[idx] = balls[i];
      balls[i] = temp;
    }
    System.out.println(Arrays.toString(balls));
  }

}

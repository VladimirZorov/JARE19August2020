import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {

    private static int storedFlowers = 0;
    private static int wreaths = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer> roses = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(lilies::push);
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(roses::offer);

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int tempLilies = lilies.peek();
            int tempRoses = roses.peek();
            int sum = tempLilies + tempRoses;
            if (sum > 15) {
                lilies.addFirst(lilies.pop()-2);
            }
            if (sum == 15) {
                wreaths++;
                lilies.pop();
                roses.poll();
            }  else if (sum < 15) {
                storedFlowers += lilies.pop();
                storedFlowers += roses.poll();
            }

        }

        wreaths += storedFlowers/15;

        if (wreaths >=5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }
}

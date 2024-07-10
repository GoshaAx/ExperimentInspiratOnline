import java.util.ArrayList;
import java.util.Collections;

public class Sum_5 {

    public static void genereazaNumere(int S, ArrayList<Integer> currentNumber, int startDigit) {
        int sum = 0;
        for (int digit : currentNumber) {
            sum += digit;
        }

        if (sum == S) {
            Collections.reverse(currentNumber);
            for (int digit : currentNumber) {
                System.out.print(digit);
            }
            System.out.println();
            return;
        }

        for (int digit = startDigit; digit <= 9; digit++) {
            if (!currentNumber.contains(digit)) {
                currentNumber.add(digit);
                genereazaNumere(S, currentNumber, digit + 1);
                currentNumber.remove(currentNumber.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int S = 15;
        genereazaNumere(S, new ArrayList<>(), 1);
    }


    }


/*Se dă un număr natural n. Determinaţi, în ordine lexicografică,
toate modalităţile de a-l scrie pe n ca sumă de numere naturale.*/

import java.util.Scanner;

public class Permutatii {

    public static void generateSum(int n, int start, String sum) {
        if (n == 0) {
            System.out.println(sum.trim());
            return;
        }

        for (int i = start; i <= n; i++) {
            generateSum(n - i, i, sum + i + " ");
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        generateSum(n, 1, "");
        scanner.close();
    }

}

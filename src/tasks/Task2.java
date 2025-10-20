package tasks;

import java.math.BigInteger;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i< n; i++) {
            BigInteger money = scanner.nextBigInteger();
            BigInteger result = findBouquetCost(money);
            System.out.println(result);
        }
        scanner.close();
    }

    private static BigInteger findBouquetCost(BigInteger money) {
        int maxPower= -1;

        while (BigInteger.valueOf(2).pow(maxPower + 1).compareTo(money) <= 0) {
            maxPower++;
        }

        for (int a = maxPower; a >= 0; a--) {
            for (int b = a - 1; b >= 0; b--) {
                for (int c = b - 1; c >= 0; c--) {
                    BigInteger costA = BigInteger.valueOf(2).pow(a);
                    BigInteger costB = BigInteger.valueOf(2).pow(b);
                    BigInteger costC = BigInteger.valueOf(2).pow(c);

                    BigInteger totalCost = costA.add(costB).add(costC);

                    if (totalCost.compareTo(money) <= 0) {
                        return totalCost;
                    }
                }
            }
        }

        return BigInteger.valueOf(-1);
    }
}

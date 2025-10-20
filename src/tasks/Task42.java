package tasks;

import java.util.Scanner;

public class Task42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }

        System.out.println(solveTask(n, x, y, z, numbers));

        scanner.close();
    }

    private static int solveTask(int n, int x, int y, int z, long[] numbers) {
        int result = Integer.MAX_VALUE;
        int[] bestIndexes = new int[3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int operX = getMinOperations(numbers[i], x);
                    int operY = getMinOperations(numbers[j], y);
                    int operZ = getMinOperations(numbers[k], z);

                    int totalOps = operX + operY + operZ;
                    if (totalOps < result) {
                        result = totalOps;
                        bestIndexes[0] = i;
                        bestIndexes[1] = j;
                        bestIndexes[2] = k;
                    }
                }
            }
        }

        // Отладочная печать
        System.err.println("Лучшие числа: " +
                numbers[bestIndexes[0]] + " (+" + getMinOperations(numbers[bestIndexes[0]], x) + " к " + x + "), " +
                numbers[bestIndexes[1]] + " (+" + getMinOperations(numbers[bestIndexes[1]], y) + " к " + y + "), " +
                numbers[bestIndexes[2]] + " (+" + getMinOperations(numbers[bestIndexes[2]], z) + " к " + z + ")");

        return result;
    }

    private static int getMinOperations(long num, int divisor) {
        for (int add = 0; add <= 1000; add++) {
            if ((num + add) % divisor == 0) {
                return add;
            }
        }
        return 1001;
    }
}

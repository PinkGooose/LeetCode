package tasks;

import java.util.Scanner;

public class Task4 {
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int operX = getMinOperations(numbers[i], x);
                    int operY = getMinOperations(numbers[j], y);
                    int operZ = getMinOperations(numbers[k], z);

                    result = Math.min(result, operX + operY + operZ);
                }
            }
        }

        return result;
    }

    private static int getMinOperations(long num, int divisor) {
        // Только увеличиваем число
        for (int add = 0; add <= 1000; add++) {
            if ((num + add) % divisor == 0) {
                return add;
            }
        }

        // Если не нашли кратность
        return 1001;
    }
}

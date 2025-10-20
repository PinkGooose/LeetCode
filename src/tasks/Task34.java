package tasks;

import java.util.Scanner;

public class Task34 {
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
        int[] opersX = new int[n];
        int[] opersY = new int[n];
        int[] opersZ = new int[n];


    }

}

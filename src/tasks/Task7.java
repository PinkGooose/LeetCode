package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task7 {
    private static final int MOD = 998_244_353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int p = 1; p <= k; p++) {
            System.out.println(calculateFp(arr, p));
        }

        scanner.close();
    }

    private static long calculateFp(int[] arr, int p) {
        List<Integer> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                pairs.add(arr[i] + arr[j]);
            }
        }

        long sum = 0;
        for (int num : pairs) {
            sum += pow(num, p);
            sum %= MOD;
        }

        return sum;
    }

    private static long pow(long base, int exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }

        return result;
    }
}

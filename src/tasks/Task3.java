package tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Читаем входные данные
        int n = scanner.nextInt(); // количество дней
        int m = scanner.nextInt(); // требуемое количество хороших дней

        // Массив дистанций
        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
            distances[i] = scanner.nextInt();
        }

        // Минимальное количество корректировок
        System.out.println(findMinimumCorrections(n, m, distances));

        scanner.close();
    }

    // Метод для нахождения минимального количества корректировок
    private static int findMinimumCorrections(int n, int m, int[] distances) {
        int minCorrections = Integer.MAX_VALUE;

        // Перебираем все возможные диапазоны для первого и второго дня
        for (int first = distances[0] - m; first <= distances[0] + m; first++) {
            for (int second = distances[1] - m; second <= distances[1] + m; second++) {
                int corrections = 0;

                // Создаем копию дистанций для корректировок
                int[] modifiedDistances = Arrays.copyOf(distances, n);

                // Корректируем первые два дня
                if (first != distances[0]) {
                    corrections += Math.abs(first - distances[0]);
                    modifiedDistances[0] = first;
                }

                if (second != distances[1]) {
                    corrections += Math.abs(second - distances[1]);
                    modifiedDistances[1] = second;
                }

                // Проверяем и корректируем остальные дни
                int goodDays = 0;
                for (int i = 2; i < n; i++) {
                    int target = modifiedDistances[i];
                    int left = Math.min(first, second);
                    int right = Math.max(first, second);

                    // Сколько нужно корректировок для текущего дня
                    if (target < left) {
                        int needed = left - target;
                        corrections += needed;
                        target += needed;
                    } else if (target > right) {
                        int needed = target - right;
                        corrections += needed;
                        target -= needed;
                    }

                    modifiedDistances[i] = target;

                    // Проверяем, является ли день хорошим
                    if (target >= left && target <= right) {
                        goodDays++;
                    }
                }

                // Обновляем минимальное количество корректировок
                if (goodDays >= m) {
                    minCorrections = Math.min(minCorrections, corrections);
                }
            }
        }

        return minCorrections;
    }
}

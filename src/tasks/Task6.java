package tasks;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt(), i);
        }

        System.out.println(findMaxHappyTriples(points));

        scanner.close();
    }

    private static int findMaxHappyTriples(Point[] points) {
        int n = points.length;
        boolean[] used = new boolean[n];
        int happyTriples = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (!used[points[i].index] &&
                            !used[points[j].index] &&
                            !used[points[k].index] &&
                            !areCollinear(points[i], points[j], points[k])) {

                        used[points[i].index] = true;
                        used[points[j].index] = true;
                        used[points[k].index] = true;

                        happyTriples++;
                    }
                }
            }
        }

        return happyTriples;
    }

    private static boolean areCollinear(Point a, Point b, Point c) {
        return (long)(b.x - a.x) * (c.y - a.y) == (long)(c.x - a.x) * (b.y - a.y);
    }

    static class Point {
        int x, y, index;

        Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }
}

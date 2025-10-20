package stepik;

import java.util.Arrays;
import java.util.Scanner;

public class SecondMinimal {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();

        in.nextLine(); //Для очистки буфера

        String input = in.nextLine();
        String[] numbers = input.trim().split("\\s+");

        int[] array = new int[amount];
        for (int i = 0; i < amount; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }

        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);

        System.out.println(sortedArray[1]);
        in.close();
    }

    //Затраты ресурсов на такое решение O(n log n), но есть второй способ, который затрачивает O(n)
}

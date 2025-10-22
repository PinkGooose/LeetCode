package algorithm;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {
    public static boolean searchSubstring(String str, String subStr) {
        //Создаем мапу сдвигов символов
        Map<Character, Integer> shift = new HashMap<>();
        for (int i = 0; i < subStr.length(); i++) {
            shift.put(subStr.charAt(i), Math.max(1, subStr.length() - i - 1));
        }
        //Вводим счетчик найденных повторений
        int counter = 0;
        for (int left = 0; left < str.length();) {
            int right = left + subStr.length() - 1;
            if (right > str.length()) {
                return false;
            } else {
                for (int i = subStr.length() - 1; i >= 0; i--) {
                    if (subStr.charAt(i) != str.charAt(right)) {
                        if (shift.containsKey(str.charAt(right))) {
                            left += shift.get(str.charAt(right));
                            break;
                        } else {
                            left = right + 1; //left += subStr.length()
                            break;
                        }
                    } else {
                        right--;
                        counter++;
                    }
                }
            }
            if (counter == subStr.length()) return true;
        }
        return false;
    }
}

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            /*Если текущий символ currentChar есть в set,
            то мы удаляем символ по индексу left и двигаем left на 1.
            */
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            // Добавляем текущий символ в множество
            set.add(currentChar);
            //Обновляем максимальную длину
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

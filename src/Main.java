import leetcode.NumberPalindrome;
import leetcode.RomanInteger;

import static leetcode.NumberPalindrome.isPalindrome;

public class Main {
    public static void main(String[] args) {
        String s = "LXIII";
        int romToInt = RomanInteger.romanToInt(s);
        System.out.println(romToInt);
    }
}

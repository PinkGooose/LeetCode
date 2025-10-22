import leetcode.TwoSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static algorithm.BoyerMoore.searchSubstring;

public class Main {
    public static void main(String[] args) {
        String str = "linear data structures";
        String subStr = "ser";
        Boolean getSubStr = searchSubstring(str, subStr);
        System.out.println(getSubStr);
    }
}

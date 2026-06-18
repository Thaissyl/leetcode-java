package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// === BẠN SẼ HOÀN THIỆN PHƯƠNG THỨC NÀY VÀO TRONG FILE ===
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        
        for (int check : arr) {
            if (check != 0) {
                return false;
            }
        }
        return true;
    }
}

// === HÀM MAIN CHỨA CÁC TESTCASE ĐỂ CHẠY THỬ ===
public class Leet242_ValidAnagram {
    public static void main(String[] args) {
        System.out.println("=== 242: VALID ANAGRAM ===");

        Solution solution = new Solution();

        // Testcase 1: Trường hợp là Anagram thuần túy
        String s1 = "anagram";
        String t1 = "nagaram";
        boolean res1 = solution.isAnagram(s1, t1);
        System.out.println("Input: s = anagram, t = nagaram");
        System.out.println("Test 1: " + res1);

        // Testcase 2: Trường hợp sai khác ký tự
        String s2 = "rat";
        String t2 = "car";
        boolean res2 = solution.isAnagram(s2, t2);
        System.out.println("Input: s = rat, t = car");
        System.out.println("Test 2: " + res2);

        // Testcase 3: Độ dài khác nhau (Không thể là Anagram)
        String s3 = "a";
        String t3 = "ab";
        boolean res3 = solution.isAnagram(s3, t3);
        System.out.println("Input: s = a, t = ab");
        System.out.println("Test 3: " + res3);

        // Testcase 4: Cùng các chữ cái nhưng sai số lượng tần suất
        String s4 = "aacc";
        String t4 = "ccac";
        boolean res4 = solution.isAnagram(s4, t4);
        System.out.println("Input: s = aacc, t = ccac");
        System.out.println("Test 4: " + res4);
    }
}
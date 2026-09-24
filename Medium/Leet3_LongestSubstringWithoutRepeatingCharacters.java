package Medium;

import java.util.*;

public class Leet3_LongestSubstringWithoutRepeatingCharacters {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currentChar);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 3: LONGEST SUBSTRING WITHOUT REPEATING ===");
        System.out.println("-----------------------------------------------------------");

        // Testcase 1: Chuỗi thông thường có chu kỳ lặp
        String s1 = "abcabcbb";
        inKetQua(1, s1, 3); // "abc" -> 3

        // Testcase 2: Chuỗi chỉ toàn ký tự giống nhau
        String s2 = "bbbbb";
        inKetQua(2, s2, 1); // "b" -> 1

        // Testcase 3: Substring dài nhất nằm ở giữa
        String s3 = "pwwkew";
        inKetQua(3, s3, 3); // "wke" -> 3

        // Testcase 4: Chuỗi rỗng
        String s4 = "";
        inKetQua(4, s4, 0);

        // Testcase 5: Chuỗi có dấu cách
        String s5 = " ";
        inKetQua(5, s5, 1);
    }

    private static void inKetQua(int testNo, String s, int expected) {
        int actual = lengthOfLongestSubstring(s);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Input s     : \"" + s + "\"");
        System.out.println("Output      : " + actual);
        System.out.println("Expected    : " + expected);
        System.out.println(actual == expected ? "👉 KẾT QUẢ: CHÍNH XÁC ✅" : "👉 KẾT QUẢ: SAI LẦM ❌");
        System.out.println("-----------------------------------------------------------");
    }
}
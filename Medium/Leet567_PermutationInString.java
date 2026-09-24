package Medium;

import java.util.Arrays;

public class Leet567_PermutationInString {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            countS1[s1.charAt(i) - 'a']++;
            countS2[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(countS1, countS2)) {
                return true;
            }
            countS2[s2.charAt(i) - 'a']++;

            countS2[s2.charAt(i - s1.length()) - 'a']--;
        }
        
        return Arrays.equals(countS1, countS2);
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 567: PERMUTATION IN STRING ===");
        System.out.println("------------------------------------------------");

        // Testcase 1: Tồn tại hoán vị "ba"
        inKetQua(1, "ab", "eidbaooo", true);

        // Testcase 2: Không tồn tại hoán vị liền kề
        inKetQua(2, "ab", "eidboaoo", false);

        // Testcase 3: Chuỗi s1 dài hơn s2
        inKetQua(3, "hello", "ooolleeeheh", false);

        // Testcase 4: s1 và s2 giống hệt nhau
        inKetQua(4, "adc", "dcda", true);

        // Testcase 5: Ký tự lặp nhiều lần
        inKetQua(5, "aab", "baaa", true);
    }

    private static void inKetQua(int testNo, String s1, String s2, boolean expected) {
        boolean actual = checkInclusion(s1, s2);
        System.out.println("Testcase " + testNo + ": s1 = \"" + s1 + "\", s2 = \"" + s2 + "\"");
        System.out.println("Output      : " + actual);
        System.out.println("Expected    : " + expected);
        System.out.println(actual == expected ? "👉 KẾT QUẢ: CHÍNH XÁC ✅" : "👉 KẾT QUẢ: SAI LẦM ❌");
        System.out.println("------------------------------------------------");
    }
}
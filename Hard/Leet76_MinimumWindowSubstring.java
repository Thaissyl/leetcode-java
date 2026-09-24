package Hard;

public class Leet76_MinimumWindowSubstring {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] targetMap = new int[128];
        int targetCount = 0;
        for (char c : t.toCharArray()) {
            if (targetMap[c] == 0) {
                targetCount++;
            }
            targetMap[c]++;
        }

        int[] windowMap = new int[128];
        int matched = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndx = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char inChar = s.charAt(right);
            windowMap[inChar]++;
            if (targetMap[inChar] > 0 && windowMap[inChar] == targetMap[inChar]) {
                matched++;
            }

            while (matched == targetCount) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndx = left;
                }

                char outChar = s.charAt(left);
                windowMap[outChar]--;

                if (targetMap[outChar] > 0 && windowMap[outChar] < targetMap[outChar]) {
                    matched--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndx, startIndx + minLen);
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 76: MINIMUM WINDOW SUBSTRING ===");
        System.out.println("-------------------------------------------------");

        // Testcase 1: Bình thường, kết quả ở cuối
        inKetQua(1, "ADOBECODEBANC", "ABC", "BANC");

        // Testcase 2: Chuỗi 1 ký tự khớp
        inKetQua(2, "a", "a", "a");

        // Testcase 3: Thiếu số lượng ký tự lặp
        inKetQua(3, "a", "aa", "");

        // Testcase 4: t có ký tự lặp
        inKetQua(4, "aaflslflsfddabb", "ab", "ab");
    }

    private static void inKetQua(int testNo, String s, String t, String expected) {
        String actual = minWindow(s, t);
        System.out.println("Testcase " + testNo + ": s = \"" + s + "\", t = \"" + t + "\"");
        System.out.println("Output      : \"" + actual + "\"");
        System.out.println("Expected    : \"" + expected + "\"");
        System.out.println(actual.equals(expected) ? "👉 KẾT QUẢ: CHÍNH XÁC ✅" : "👉 KẾT QUẢ: SAI LẦM ❌");
        System.out.println("-------------------------------------------------");
    }
}
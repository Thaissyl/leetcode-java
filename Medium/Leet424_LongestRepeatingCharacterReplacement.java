package Medium;

public class Leet424_LongestRepeatingCharacterReplacement {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int characterReplacement(String s, int k) {
        // Bước 1: Mảng count 26 phần tử để đếm số lần xuất hiện của các chữ cái trong cửa sổ
        int[] count = new int[26];
        int left = 0, maxCount = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 424: LONGEST REPEATING CHARACTER REPLACEMENT ===");
        System.out.println("----------------------------------------------------------------");

        // Testcase 1: Thay thế tối đa 2 ký tự
        inKetQua(1, "ABAB", 2, 4);

        // Testcase 2: Thay thế 1 ký tự
        inKetQua(2, "AABABBA", 1, 4);

        // Testcase 3: k = 0 (không được thay thế ký tự nào)
        inKetQua(3, "AAAB", 0, 3);

        // Testcase 4: Chuỗi chỉ có 1 ký tự
        inKetQua(4, "A", 0, 1);

        // Testcase 5: k lớn hơn hoặc bằng độ dài chuỗi
        inKetQua(5, "ABCDE", 5, 5);
    }

    private static void inKetQua(int testNo, String s, int k, int expected) {
        int actual = characterReplacement(s, k);
        System.out.println("Testcase " + testNo + ": s = \"" + s + "\", k = " + k);
        System.out.println("Output      : " + actual);
        System.out.println("Expected    : " + expected);
        System.out.println(actual == expected ? "👉 KẾT QUẢ: CHÍNH XÁC ✅" : "👉 KẾT QUẢ: SAI LẦM ❌");
        System.out.println("----------------------------------------------------------------");
    }
}
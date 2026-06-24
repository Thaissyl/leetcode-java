package Medium;

public class Leet5_LongestPalindrome {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static String longestPalindrome(String s) {
        int start = 0, maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandRange(s, i, i);      // lẻ
            int len2 = expandRange(s, i, i + 1);  // chẵn

            int len = Math.max(len1, len2);

            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }
        
        return s.substring(start, start + maxLength);
    }

    private static int expandRange(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 5: LONGEST PALINDROMIC SUBSTRING ===");
        System.out.println("-----------------------------------------------------");

        // Testcase 1: Trường hợp tâm lẻ thịnh hành
        inKetQua(1, "babad", "bab"); // "aba" cũng đúng

        // Testcase 2: Trường hợp tâm chẵn
        inKetQua(2, "cbbd", "bb");

        // Testcase 3: Chuỗi có độc một ký tự
        inKetQua(3, "a", "a");

        // Testcase 4: Chuỗi đối xứng hoàn toàn
        inKetQua(4, "racecar", "racecar");
    }

    private static void inKetQua(int testNo, String s, String expected) {
        String actual = longestPalindrome(s);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("   📥 Input : \"" + s + "\"");
        System.out.println("   📤 Output: \"" + actual + "\"");
    }
}
package Easy;

import java.util.Arrays;

public class Leet387_FirstUniqueChar {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (count[ch - 'a'] == 1) {
                return i;
            }
        }

        return -1; // Mặc định trả về -1 nếu không tìm thấy
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐỂ CHẠY THỬ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 387: FIRST UNIQUE CHARACTER ===");

        // Testcase 1: "leetcode"
        // Chữ 'l' xuất hiện đúng 1 lần và ở ngay đầu tiên (index 0)
        String s1 = "leetcode";
        inKetQua(1, s1, 0);

        // Testcase 2: "loveleetcode"
        // Chữ 'l' lặp lại, 'o' lặp lại, chữ 'v' xuất hiện 1 lần duy nhất ở index 2
        String s2 = "loveleetcode";
        inKetQua(2, s2, 2);

        // Testcase 3: "aabb"
        // Tất cả các chữ đều xuất hiện 2 lần, không có chữ nào duy nhất
        String s3 = "aabb";
        inKetQua(3, s3, -1);
    }

    // Hàm phụ trợ in kết quả tự động đánh giá Đúng/Sai
    private static void inKetQua(int testNo, String s, int expected) {
        int actual = firstUniqChar(s);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Input: s = \"" + s + "\"");
        System.out.println("Result: " + actual);
    }
}
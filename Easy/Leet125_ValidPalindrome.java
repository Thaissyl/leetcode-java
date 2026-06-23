package Easy;

public class Leet125_ValidPalindrome {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐÃ LÀM GỌN ĐẸP ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 125: VALID PALINDROME ===");
        System.out.println("-----------------------------------------");

        // Testcase 1
        String s1 = "A man, a plan, a canal: Panama";
        inKetQua(1, s1, true);

        // Testcase 2
        String s2 = "race a car";
        inKetQua(2, s2, false);

        // Testcase 3
        String s3 = " ";
        inKetQua(3, s3, true);
    }

    // === HÀM IN KẾT QUẢ ĐƠN GIẢN, TRỰC QUAN ===
    private static void inKetQua(int testNo, String s, boolean expected) {
        boolean actual = isPalindrome(s);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Input : \"" + s + "\"");
        System.out.println("Output: " + actual);
    }
}
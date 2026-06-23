package Easy;

import java.util.Stack;

public class Leet20_ValidParentheses {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐÃ LÀM GỌN ĐẸP ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 20: VALID PARENTHESES ===");
        System.out.println("-----------------------------------------");

        // Testcase 1: "()" -> Hợp lệ
        inKetQua(1, "()", true);

        // Testcase 2: "()[]{}" -> Hợp lệ
        inKetQua(2, "()[]{}", true);

        // Testcase 3: "(]" -> Không hợp lệ vì mở tròn đóng vuông
        inKetQua(3, "(]", false);

        // Testcase 4: "([)]" -> Không hợp lệ vì sai thứ tự đóng mở
        inKetQua(4, "([)]", false);
    }

    // === HÀM IN KẾT QUẢ ĐƠN GIẢN, TRỰC QUAN ===
    private static void inKetQua(int testNo, String s, boolean expected) {
        boolean actual = isValid(s);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("   📥 Input : \"" + s + "\"");
        System.out.println("   📤 Result: " + actual);
    }
}
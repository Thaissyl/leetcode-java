package Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Leet150_EvaluateRPN_RecursionSolution {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int evalRPN(String[] tokens) {
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
        return dfs(tokenList);
    }

    private static int dfs(List<String> tokens) {
        String token = tokens.remove(tokens.size() - 1);
        if (!"+-*/".contains(token)) {
            return Integer.parseInt(token);
        }

        int right = dfs(tokens);
        int left = dfs(tokens);

        switch (token) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*": 
                return left * right;
            case "/":
                return left / right;
        }
        return 0;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐÃ LÀM GỌN ĐẸP ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 150: EVALUATE RPN ===");
        System.out.println("-----------------------------------------");

        // Testcase 1: ["2", "1", "+", "3", "*"]
        // Tương đương: (2 + 1) * 3 = 9
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        inKetQua(1, tokens1, 9);

        // Testcase 2: ["4", "13", "5", "/", "+"]
        // Tương đương: 4 + (13 / 5) = 4 + 2 = 6 (chia lấy nguyên)
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        inKetQua(2, tokens2, 6);

        // Testcase 3: Biểu thức dài phức tạp
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        inKetQua(3, tokens3, 22);
    }

    // === HÀM IN KẾT QUẢ ĐƠN GIẢN, TRỰC QUAN ===
    private static void inKetQua(int testNo, String[] tokens, int expected) {
        int actual = evalRPN(tokens);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("   📥 Input length: " + tokens.length);
        System.out.println("   📤 Output      : " + actual);
    }
}
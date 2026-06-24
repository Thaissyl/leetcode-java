package Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leet739_DailyTemperatures {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐÃ LÀM GỌN ĐẸP ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 739: DAILY TEMPERATURES ===");
        System.out.println("---------------------------------------------");

        // Testcase 1: Dãy nhiệt độ biến động chuẩn
        int[] temps1 = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] expected1 = { 1, 1, 4, 2, 1, 1, 0, 0 };
        inKetQua(1, temps1, expected1);

        // Testcase 2: Dãy tăng dần đều
        int[] temps2 = { 30, 40, 50, 60 };
        int[] expected2 = { 1, 1, 1, 0 };
        inKetQua(2, temps2, expected2);

        // Testcase 3: Dãy giảm dần đều
        int[] temps3 = { 30, 20, 10 };
        int[] expected3 = { 0, 0, 0 };
        inKetQua(3, temps3, expected3);
    }

    private static void inKetQua(int testNo, int[] temps, int[] expected) {
        int[] actual = dailyTemperatures(temps);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("   📥 Input : " + Arrays.toString(temps));
        System.out.println("   📤 Output: " + Arrays.toString(actual));
    }
}
package Medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Leet155_MinStack {

    // === BẠN TỰ THIẾT KẾ CẤU TRÚC ĐỐI TƯỢNG TRONG LỚP NÀY ===
    static class MinStack {
        private Deque<Integer> mainStack;
        private Deque<Integer> minStack;

        public MinStack() {
            mainStack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int val) {
            mainStack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (mainStack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            mainStack.pop();
        }

        public int top() {
            return mainStack.peek();
        }

        public int getMin() {
            // [Viết code lấy số nhỏ nhất hiện tại]
            return minStack.peek();
        }
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐỂ CHẠY THỬ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 155: MIN STACK ===");
        System.out.println("-----------------------------------------");

        MinStack minStack = new MinStack();

        // Thử nghiệm theo đúng kịch bản của LeetCode
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("Testcase 1 (getMin): " + minStack.getMin() + " (Kỳ vọng: -3)");

        minStack.pop(); // Xóa số -3 đi

        System.out.println("Testcase 2 (top)   : " + minStack.top() + " (Kỳ vọng: 0)");
        System.out.println("Testcase 3 (getMin): " + minStack.getMin() + " (Kỳ vọng: -2)");
        System.out.println("-----------------------------------------");
    }
}
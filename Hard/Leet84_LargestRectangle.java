package Hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leet84_LargestRectangle {

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        //height {2, 1, 5, 6, 2, 3}  
        //index   0  1  2  3  4  5   
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int targetIndex = stack.pop();
                int h = heights[targetIndex];

                int rightBond = i;
                int leftBond = stack.isEmpty() ? -1 : stack.peek();
                int width = rightBond - leftBond - 1;
                
                maxArea = Math.max(maxArea, h * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN ĐẸP ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 84: LARGEST RECTANGLE IN HISTOGRAM ===");
        System.out.println("-------------------------------------------------------");

        // Testcase 1: Ví dụ mô tả chuẩn
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        inKetQua(1, heights1, 10);

        // Testcase 2: Hai cột bằng nhau
        int[] heights2 = {2, 4};
        inKetQua(2, heights2, 4);

        // Testcase 3: Dãy giảm dần
        int[] heights3 = {5, 4, 3, 2, 1};
        inKetQua(3, heights3, 9); // Cột 3, 2, 1 gộp lại nền cao 3 cột rộng 3 -> 3*3 = 9
    }

    private static void inKetQua(int testNo, int[] heights, int expected) {
        int actual = largestRectangleArea(heights);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("   📤 Output      : " + actual);
    }
}
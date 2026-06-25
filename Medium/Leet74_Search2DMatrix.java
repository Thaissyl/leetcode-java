package Medium;

import java.text.CollationElementIterator;

public class Leet74_Search2DMatrix {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int ROWS = matrix.length; // số hàng
        int COLS = matrix[0].length; // số cột

        int left = 0;
        int right = ROWS * COLS - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid/COLS][mid%COLS];
            
            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 74: SEARCH A 2D MATRIX ===");
        System.out.println("-------------------------------------------");

        int[][] matrix = {
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        // Testcase 1: Số có tồn tại trong ma trận
        System.out.print("Testcase 1 (target = 3): ");
        System.out.println(searchMatrix(matrix, 3) ? "✅ ĐÚNG (Passed)" : "❌ SAI (Failed)");

        // Testcase 2: Số không tồn tại trong ma trận
        System.out.print("Testcase 2 (target = 13): ");
        System.out.println(!searchMatrix(matrix, 13) ? "✅ ĐÚNG (Passed)" : "❌ SAI (Failed)");
    }
}
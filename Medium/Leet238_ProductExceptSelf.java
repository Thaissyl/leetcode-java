package Medium;

import java.util.Arrays;

public class Leet238_ProductExceptSelf {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }

        return result; 
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐỂ CHẠY THỬ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 238: PRODUCT OF ARRAY EXCEPT SELF ===");

        // Testcase 1: [1, 2, 3, 4]
        // Tại ô số 1: tích là 2 * 3 * 4 = 24
        // Tại ô số 2: tích là 1 * 3 * 4 = 12
        // Tại ô số 3: tích là 1 * 2 * 4 = 8
        // Tại ô số 4: tích là 1 * 2 * 3 = 6
        int[] nums1 = {1, 2, 3, 4};
        int[] expected1 = {24, 12, 8, 6};
        inKetQua(1, nums1, expected1);

        // Testcase 2: [-1, 1, 0, -3, 3]
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] expected2 = {0, 0, 9, 0, 0};
        inKetQua(2, nums2, expected2);
    }

    // Hàm phụ trợ in kết quả tự động đánh giá
    private static void inKetQua(int testNo, int[] nums, int[] expected) {
        int[] actual = productExceptSelf(nums);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Result: " + Arrays.toString(actual));
    }
}
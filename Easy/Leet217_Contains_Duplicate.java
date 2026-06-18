package Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leet217_Contains_Duplicate {

    // === BẠN VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (numsSet.contains(nums[i])) {
                return true;
            }
            numsSet.add(nums[i]);
        }
        return false;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐỂ CHẠY THỬ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 217: CONTAINS DUPLICATE ===");

        // Testcase 1: [1, 2, 3, 1]
        int[] nums1 = {1, 2, 3, 1};
        inKetQua(1, nums1, true);

        // Testcase 2: [1, 2, 3, 4]
        int[] nums2 = {1, 2, 3, 4};
        inKetQua(2, nums2, false);

        // Testcase 3: [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        inKetQua(3, nums3, true);
    }

    // Hàm phụ trợ in kết quả tự động đánh giá Đúng/Sai
    private static void inKetQua(int testNo, int[] nums, boolean expected) {
        boolean actual = containsDuplicate(nums);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Result: " + actual);
    }
}
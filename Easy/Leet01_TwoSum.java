package Easy;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Leet01_TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(nums[i], i);
        }

        return new int[]{};
    }

    // === HÀM MAIN CHỨA 3 TESTCASE CỦA BẠN ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 1: TWO SUM ===");

        // Testcase 1: [2, 7, 11, 15], target = 9
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        inKetQua(1, nums1, target1);

        // Testcase 2: [3, 2, 4], target = 6
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        inKetQua(2, nums2, target2);

        // Testcase 3: [3, 3], target = 6
        int[] nums3 = {3, 3};
        int target3 = 6;
        inKetQua(3, nums3, target3);
    }

    // Hàm phụ trợ để in kết quả ra Terminal cho đẹp
    private static void inKetQua(int testNo, int[] nums, int target) {
        int[] result = twoSum(nums, target);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("   Input: nums = " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("   Output: " + Arrays.toString(result));
        System.out.println("-----------------------------------------");
    }
}
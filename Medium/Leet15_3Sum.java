package Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet15_3Sum {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) { // Chỉ cần chạy đến n - 2 vì ta cần bộ 3 số
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // Sau khi bỏ qua số trùng, BẮT BUỘC phải dịch chuyển hai con trỏ tiếp
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Tổng nhỏ quá thì tăng left để lấy số lớn hơn
                } else {
                    right--; // Tổng to quá thì giảm right để lấy số nhỏ hơn
                }
            }
        }

        return result;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐÃ LÀM GỌN ĐẸP ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 15: 3SUM ===");
        System.out.println("-----------------------------------------");

        // Testcase 1: [-1, 0, 1, 2, -1, -4]
        // Có 2 bộ ba có tổng bằng 0 là: [-1, -1, 2] và [-1, 0, 1]
        int[] nums1 = { -1, 0, 1, 2, -1, -4 };
        inKetQua(1, nums1, "[[-1, -1, 2], [-1, 0, 1]]");

        // Testcase 2: [0, 1, 1]
        // Không có bộ ba nào tổng bằng 0 -> Kỳ vọng: []
        int[] nums2 = { 0, 1, 1 };
        inKetQua(2, nums2, "[]");

        // Testcase 3: [0, 0, 0]
        // Bộ ba duy nhất: [0, 0, 0]
        int[] nums3 = { 0, 0, 0 };
        inKetQua(3, nums3, "[[0, 0, 0]]");
    }

    // === HÀM IN KẾT QUẢ ĐƠN GIẢN, TRỰC QUAN ===
    private static void inKetQua(int testNo, int[] nums, String expected) {
        List<List<Integer>> actual = threeSum(nums);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("   📥 Input : " + Arrays.toString(nums));
        System.out.println("   📤 Output: " + actual);
        System.out.println("   💡 Target: " + expected);
        System.out.println("-----------------------------------------");
    }
}
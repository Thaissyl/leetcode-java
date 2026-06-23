package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leet167_TwoSumII {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = target - numbers[i];
            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), (i+1)};
            }
            hashMap.put(numbers[i], (i+1));
        }
        return new int[]{};
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐÃ LÀM GỌN ĐẸP ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 167: TWO SUM II ===");
        System.out.println("-----------------------------------------");

        // Testcase 1: [2, 7, 11, 15], Target = 9
        // Số 2 (vị trí 1) + Số 7 (vị trí 2) = 9 -> Kỳ vọng: [1, 2]
        int[] nums1 = {2, 7, 11, 15};
        inKetQua(1, nums1, 9, new int[]{1, 2});

        // Testcase 2: [2, 3, 4], Target = 6
        // Số 2 (vị trí 1) + Số 4 (vị trí 3) = 6 -> Kỳ vọng: [1, 3]
        int[] nums2 = {2, 3, 4};
        inKetQua(2, nums2, 6, new int[]{1, 3});

        // Testcase 3: [-1, 0], Target = -1
        // Số -1 (vị trí 1) + Số 0 (vị trí 2) = -1 -> Kỳ vọng: [1, 2]
        int[] nums3 = {-1, 0};
        inKetQua(3, nums3, -1, new int[]{1, 2});
    }

    // === HÀM IN KẾT QUẢ ĐƠN GIẢN, TRỰC QUAN ===
    private static void inKetQua(int testNo, int[] numbers, int target, int[] expected) {
        int[] actual = twoSum(numbers, target);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Input : numbers = " + Arrays.toString(numbers) + ", target = " + target);
        System.out.println("Output: " + Arrays.toString(actual));
    }
}
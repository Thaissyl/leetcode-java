package Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leet349_Intersection_of_Two_Arrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();

        for (int num : nums1) {
            nums1Set.add(num);
        }

        Set<Integer> intersectSet = new HashSet<>();
        for (int num : nums2) {
            if (nums1Set.contains(num)) {
                intersectSet.add(num);
            }
        }
        int[] result = new int[intersectSet.size()];
        int index = 0;
        for (int num : intersectSet) {
            result[index++] = num;
        }
        return result;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐỂ CHẠY THỬ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 349: INTERSECTION OF TWO ARRAYS ===");

        // Testcase 1
        int[] nums1_1 = {1, 2, 2, 1};
        int[] nums1_2 = {2, 2};
        int[] expected1 = {2};
        inKetQua(1, nums1_1, nums1_2, expected1);

        // Testcase 2
        int[] nums2_1 = {4, 9, 5};
        int[] nums2_2 = {9, 4, 9, 8, 4};
        int[] expected2 = {4, 9}; // Hoặc [9, 4] đều đúng
        inKetQua(2, nums2_1, nums2_2, expected2);
    }

    // Hàm phụ trợ so sánh mảng tự động (không quan trọng thứ tự phần tử)
    private static void inKetQua(int testNo, int[] nums1, int[] nums2, int[] expected) {
        int[] actual = intersection(nums1, nums2);
        
        // Sắp xếp lại trước khi so sánh vì thứ tự kết quả không quan trọng
        Arrays.sort(actual);
        Arrays.sort(expected);

        System.out.println("Testcase " + testNo + ":");
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", nums2 = " + Arrays.toString(nums2));
        System.out.println("Result: " + Arrays.toString(actual));
        
    }
}
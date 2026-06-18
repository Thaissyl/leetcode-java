package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leet350_IntersectionOfTwoArraysII {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();

        for (int num : nums1) {
            nums1Map.put(num, nums1Map.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersectionList = new ArrayList<>();
        for (int num : nums2) {
            if (nums1Map.containsKey(num) && nums1Map.get(num) > 0) {
                intersectionList.add(num);

                nums1Map.put(num, nums1Map.get(num) - 1);
            }
        }
        
        int[] result = new int[intersectionList.size()];
        int index = 0;
        for (int num : intersectionList) {
            result[index++] = num;
        }
        return result;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐỂ CHẠY THỬ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 350: INTERSECTION OF TWO ARRAYS II ===");

        // Testcase 1
        int[] nums1_1 = {1, 2, 2, 1};
        int[] nums1_2 = {2, 2};
        int[] expected1 = {2, 2}; // Số 2 xuất hiện 2 lần ở cả 2 bên
        inKetQua(1, nums1_1, nums1_2, expected1);

        // Testcase 2
        int[] nums2_1 = {4, 9, 5};
        int[] nums2_2 = {9, 4, 9, 8, 4};
        int[] expected2 = {4, 9}; // Số 4 và 9 chỉ giao nhau đúng 1 lần chung
        inKetQua(2, nums2_1, nums2_2, expected2);
    }

    // Hàm phụ trợ so sánh mảng tự động
    private static void inKetQua(int testNo, int[] nums1, int[] nums2, int[] expected) {
        int[] actual = intersect(nums1, nums2);
        
        // Sắp xếp lại trước khi so sánh vì thứ tự kết quả không quan trọng
        Arrays.sort(actual);
        Arrays.sort(expected);

        System.out.println("Testcase " + testNo + ":");
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", nums2 = " + Arrays.toString(nums2));
        System.out.println("Result: " + Arrays.toString(actual));
    }
}
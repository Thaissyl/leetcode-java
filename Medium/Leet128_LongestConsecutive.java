package Medium;

import java.util.HashSet;
import java.util.Set;

public class Leet128_LongestConsecutive {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐỂ CHẠY THỬ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 128: LONGEST CONSECUTIVE SEQUENCE ===");

        // Testcase 1: [100, 4, 200, 1, 3, 2]
        // Chuỗi các số liên tiếp dài nhất có thể sắp xếp lại là: [1, 2, 3, 4] -> Chiều dài = 4.
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Testcase 1: " + longestConsecutive(nums1) + " (Kỳ vọng: 4)");

        // Testcase 2: [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
        // Chuỗi liên tiếp dài nhất: [0, 1, 2, 3, 4, 5, 6, 7, 8] -> Chiều dài = 9.
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Testcase 2: " + longestConsecutive(nums2) + " (Kỳ vọng: 9)");
    }
}
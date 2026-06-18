package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet347_TopKFrequent {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int num : map.keySet()) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int index = 0;
        int[] result = new int[minHeap.size()];
        for (int num : minHeap) {
            result[index++] = num;
        }

        return result; 
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐỂ CHẠY THỬ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 347: TOP K FREQUENT ELEMENTS ===");

        // Testcase 1: [1,1,1,2,2,3], k = 2
        // Số 1 xuất hiện 3 lần, số 2 xuất hiện 2 lần, số 3 xuất hiện 1 lần.
        // Top 2 phần tử nhiều nhất là 1 và 2.
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] expected1 = {1, 2};
        inKetQua(1, nums1, k1, expected1);

        // Testcase 2: [1], k = 1
        int[] nums2 = {1};
        int k2 = 1;
        int[] expected2 = {1};
        inKetQua(2, nums2, k2, expected2);
    }

    // Hàm phụ trợ in kết quả tự động đánh giá
    private static void inKetQua(int testNo, int[] nums, int k, int[] expected) {
        int[] actual = topKFrequent(nums, k);
        
        // Sắp xếp lại trước khi so sánh vì thứ tự kết quả không quan trọng
        Arrays.sort(actual);
        Arrays.sort(expected);

        System.out.println("Testcase " + testNo + ":");
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", k = " + k);
        System.out.println("Result: " + Arrays.toString(actual));
    }
}
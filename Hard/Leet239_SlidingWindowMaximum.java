package Hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leet239_SlidingWindowMaximum {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 239: SLIDING WINDOW MAXIMUM ===");
        System.out.println("-------------------------------------------------");

        // Testcase 1: Ví dụ kinh điển
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        inKetQua(1, nums1, 3, new int[]{3, 3, 5, 5, 6, 7});

        // Testcase 2: Mảng 1 phần tử
        int[] nums2 = {1};
        inKetQua(2, nums2, 1, new int[]{1});

        // Testcase 3: Mảng giảm dần
        int[] nums3 = {9, 8, 7, 6, 5};
        inKetQua(3, nums3, 3, new int[]{9, 8, 7});

        // Testcase 4: Mảng tăng dần
        int[] nums4 = {1, 2, 3, 4, 5};
        inKetQua(4, nums4, 3, new int[]{3, 4, 5});
    }

    private static void inKetQua(int testNo, int[] nums, int k, int[] expected) {
        int[] actual = maxSlidingWindow(nums, k);
        System.out.println("Testcase " + testNo + ": k = " + k);
        System.out.println("Output      : " + Arrays.toString(actual));
        System.out.println("Expected    : " + Arrays.toString(expected));
        System.out.println(Arrays.equals(actual, expected) ? "👉 KẾT QUẢ: CHÍNH XÁC ✅" : "👉 KẾT QUẢ: SAI LẦM ❌");
        System.out.println("-------------------------------------------------");
    }
}
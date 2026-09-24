package Hard; // Bạn có thể sửa thành package phù hợp nếu muốn

public class Leet4_MedianOfTwoSortedArrays {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;

        int left = 0, right = m;
        while (left <= right) {
            int cut1 = left + (right - left) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int R1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

            int L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int R2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if (L1 <= R2 && L2 <= R1) {
                // Tổng chẵn
                if ((m + n) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                }
                // Tổng lẻ
                return Math.max(L1, L2);
            }

            if (L1 > R2) {
                right = cut1 - 1;
            } else {
                left = cut1 + 1;
            }
        }
        return 0.0;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 4: MEDIAN OF TWO SORTED ARRAYS ===");
        System.out.println("---------------------------------------------------");

        // Testcase 1: Tổng số phần tử là lẻ
        int[] nums1_1 = {1, 3};
        int[] nums1_2 = {2};
        inKetQua(1, nums1_1, nums1_2, 2.0);

        // Testcase 2: Tổng số phần tử là chẵn
        int[] nums2_1 = {1, 2};
        int[] nums2_2 = {3, 4};
        inKetQua(2, nums2_1, nums2_2, 2.5);

        // Testcase 3: Một mảng bị rỗng
        int[] nums3_1 = {};
        int[] nums3_2 = {1};
        inKetQua(3, nums3_1, nums3_2, 1.0);
    }

    private static void inKetQua(int testNo, int[] nums1, int[] nums2, double expected) {
        double actual = findMedianSortedArrays(nums1, nums2);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Output      : " + actual);
        System.out.println("Expected    : " + expected);
        System.out.println(Math.abs(actual - expected) < 1e-5 ? "👉 KẾT QUẢ: CHÍNH XÁC ✅" : "👉 KẾT QUẢ: SAI LẦM ❌");
        System.out.println("---------------------------------------------------");
    }
}
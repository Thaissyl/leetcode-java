package Medium;

public class Leet153_FindMinimumInRotatedSortedArray {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 153: FIND MINIMUM IN ROTATED SORTED ARRAY ===");
        System.out.println("-------------------------------------------------------------");

        // Testcase 1: Mảng bị xoay thông thường
        int[] nums1 = {3, 4, 5, 1, 2};
        inKetQua(1, nums1, 1);

        // Testcase 2: Mảng bị xoay nhiều hơn
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        inKetQua(2, nums2, 0);

        // Testcase 3: Mảng gốc ban đầu tăng dần (xoay 0 lần hoặc xoay hết 1 vòng)
        int[] nums3 = {11, 13, 15, 17};
        inKetQua(3, nums3, 11);
    }

    private static void inKetQua(int testNo, int[] nums, int expected) {
        int actual = findMin(nums);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Output      : " + actual);
        System.out.println("Expected    : " + expected);
        System.out.println(actual == expected ? "👉 KẾT QUẢ: CHÍNH XÁC ✅" : "👉 KẾT QUẢ: SAI LẦM ❌");
        System.out.println("-------------------------------------------------------------");
    }
}
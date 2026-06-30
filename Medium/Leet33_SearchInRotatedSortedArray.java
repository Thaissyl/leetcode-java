package Medium;

public class Leet33_SearchInRotatedSortedArray {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; 
                } else {
                    right = mid - 1; 
                }
            }
        }
        return -1;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 33: SEARCH IN ROTATED SORTED ARRAY ===");
        System.out.println("-------------------------------------------------------");

        // Testcase 1: Target nằm ở nửa bên phải (vùng số nhỏ sau điểm gãy)
        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        inKetQua(1, nums1, 0, 4); // Số 0 nằm ở index 4

        // Testcase 2: Target không hề tồn tại trong mảng
        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        inKetQua(2, nums2, 3, -1); // Số 3 không có trong mảng -> -1

        // Testcase 3: Mảng gốc không bị xoay và tìm số đầu tiên
        int[] nums3 = { 1, 3, 5 };
        inKetQua(3, nums3, 1, 0); // Số 1 nằm ở index 0

        // Testcase 4: Mảng chỉ có 1 phần tử và không trùng target
        int[] nums4 = { 1 };
        inKetQua(4, nums4, 0, -1);
    }

    private static void inKetQua(int testNo, int[] nums, int target, int expected) {
        int actual = search(nums, target);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Target      : " + target);
        System.out.println("Output index: " + actual);
        System.out.println("Expected    : " + expected);
        System.out.println(actual == expected ? "👉 KẾT QUẢ: CHÍNH XÁC ✅" : "👉 KẾT QUẢ: SAI LẦM ❌");
        System.out.println("-------------------------------------------------------");
    }
}
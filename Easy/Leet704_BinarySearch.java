package Easy;

public class Leet704_BinarySearch {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; 
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 704: BINARY SEARCH ===");
        System.out.println("---------------------------------------");

        // Testcase 1: Target nằm trong mảng
        int[] nums1 = { -1, 0, 3, 5, 9, 12 };
        inKetQua(1, nums1, 9, 4);

        // Testcase 2: Target không nằm trong mảng
        int[] nums2 = { -1, 0, 3, 5, 9, 12 };
        inKetQua(2, nums2, 2, -1);
    }

    private static void inKetQua(int testNo, int[] nums, int target, int expected) {
        int actual = search(nums, target);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("   📤 Output      : " + actual);
    }
}
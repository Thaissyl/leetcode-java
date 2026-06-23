package Hard;

public class Leet42_TrappingRainWater {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT HARD VÀO TRONG HÀM NÀY ===
    public static int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = Math.max(leftMax, height[left]);
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = Math.max(rightMax, height[right]);
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 42: TRAPPING RAIN WATER ===");
        System.out.println("-----------------------------------------");

        // Testcase 1: Ví dụ kinh điển hình răng cưa
        int[] height1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        inKetQua(1, height1, 6);

        // Testcase 2: Hình cái thung lũng sâu
        int[] height2 = { 4, 2, 0, 3, 2, 5 };
        inKetQua(2, height2, 9);
    }

    private static void inKetQua(int testNo, int[] height, int expected) {
        int actual = trap(height);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Output      : " + actual);
    }
}
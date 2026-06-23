package Medium;

public class Leet11_ContainerWithMostWater {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int maxWater = 0;

        while (left < right) {
            int currentWater = (right - left) * Math.min(height[left], height[right]);
            maxWater = Math.max(currentWater, maxWater);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐÃ LÀM GỌN ĐẸP ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 11: CONTAINER WITH MOST WATER ===");
        System.out.println("-----------------------------------------");

        // Testcase 1: Đề bài ví dụ kinh điển
        // Cột cao 8 (vị trí 1) và cột cao 7 (vị trí 8) -> Rộng = 7, Cao = 7 -> Nước = 49
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        inKetQua(1, height1, 49);

        // Testcase 2: Hai cột bằng nhau
        // Rộng = 1, Cao = 1 -> Nước = 1
        int[] height2 = {1, 1};
        inKetQua(2, height2, 1);

        // Testcase 3: Cột cao ở giữa nhưng khoảng cách hẹp
        // Cột cao 10 và 10 ở cạnh nhau -> Rộng = 1, Cao = 10 -> Nước = 10
        int[] height3 = {1, 10, 10, 1};
        inKetQua(3, height3, 10);
    }

    // === HÀM IN KẾT QUẢ ĐƠN GIẢN, TRỰC QUAN ===
    private static void inKetQua(int testNo, int[] height, int expected) {
        int actual = maxArea(height);
        System.out.println("Testcase " + testNo + ":");
        // Chỉ in độ dài mảng hoặc vài phần tử nếu mảng quá dài để tránh rối mắt Terminal
        System.out.println("Input length: " + height.length);
        System.out.println("Result      : " + actual);
    }
}
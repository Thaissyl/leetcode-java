package Medium;

public class Leet875_KokoEatingBananas {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        int answer = right;
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            if (canEatAll(piles, mid, h)) {
                answer = mid;
                right = mid - 1;                
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    public static boolean canEatAll(int[] piles, int speed, int h) {
        long totalHour = 0;
        for (int pile : piles) { 
            totalHour += (long) (pile + speed - 1) / speed; 
        }
        return totalHour <= h;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 875: KOKO EATING BANANAS ===");
        System.out.println("----------------------------------------------");

        // Testcase 1: Ví dụ mô tả chuẩn
        int[] piles1 = {3, 6, 7, 11};
        inKetQua(1, piles1, 8, 4);

        // Testcase 2: Thời gian thênh thang, ăn chậm nhất có thể
        int[] piles2 = {30, 11, 23, 4, 20};
        inKetQua(2, piles2, 6, 23);
    }

    private static void inKetQua(int testNo, int[] piles, int h, int expected) {
        int actual = minEatingSpeed(piles, h);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Output      : " + actual);
    }
}
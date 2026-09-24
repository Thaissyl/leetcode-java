package Medium;

public class Leet121_BestTimeToBuyAndSellStock {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static int maxProfit(int[] prices) {
        // Bước 1: Khởi tạo biến giữ giá thấp nhất (ban đầu có thể để Integer.MAX_VALUE)
        int minPrice = Integer.MAX_VALUE;
        // Bước 2: Khởi tạo biến giữ lợi nhuận lớn nhất bằng 0
        int maxProfit = 0;
        // Bước 3: Chạy vòng lặp duyệt qua mảng prices để cập nhật 2 biến trên
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 121: BEST TIME TO BUY AND SELL STOCK ===");
        System.out.println("---------------------------------------------------------");

        // Testcase 1: Có sóng lên xuống, đỉnh xuất hiện sau đáy
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        inKetQua(1, prices1, 5);

        // Testcase 2: Giá chỉ có giảm dần
        int[] prices2 = {7, 6, 4, 3, 1};
        inKetQua(2, prices2, 0);

        // Testcase 3: Đỉnh cao nhất xuất hiện trước khi đáy thấp nhất xuất hiện
        int[] prices3 = {2, 4, 1};
        inKetQua(3, prices3, 2); // Mua 2 bán 4 lời 2 (không được mua 1 vì sau đó không còn ngày nào để bán)
    }

    private static void inKetQua(int testNo, int[] prices, int expected) {
        int actual = maxProfit(prices);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Output      : " + actual);
        System.out.println("Expected    : " + expected);
        System.out.println(actual == expected ? "👉 KẾT QUẢ: CHÍNH XÁC ✅" : "👉 KẾT QUẢ: SAI LẦM ❌");
        System.out.println("---------------------------------------------------------");
    }
}
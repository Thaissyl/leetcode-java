package Medium;

import java.util.HashMap;
import java.util.Map;

// === BẠN SẼ HOÀN THIỆN CẤU TRÚC LỚP NÀY VÀO TRONG FILE ===
class LRUCache {

    // Gợi ý thuộc tính: Cần dung lượng và cấu trúc dữ liệu phù hợp
    public LRUCache(int capacity) {
        // Khởi tạo ở đây
    }
    
    public int get(int key) {
        // [Để trống để bạn tự code]
        return -1;
    }
    
    public void put(int key, int value) {
        // [Để trống để bạn tự code]
    }
}

// === HÀM MAIN CHỨA CÁC TESTCASE ĐỂ CHẠY THỬ ===
public class Leet146_LRUCache {
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 146: LRU CACHE ===");

        // Khởi tạo cache có dung lượng là 2
        LRUCache lRUCache = new LRUCache(2);
        
        lRUCache.put(1, 1); // cache: {1=1}
        lRUCache.put(2, 2); // cache: {1=1, 2=2}
        
        System.out.println("Get(1): " + lRUCache.get(1) + " (Kỳ vọng: 1)"); // Trả về 1, cache: {2=2, 1=1} (1 vừa dùng nên lên đầu)
        
        lRUCache.put(3, 3); // Vượt dung lượng! Đuổi số 2 đi vì số 2 lâu chưa dùng. cache: {1=1, 3=3}
        
        System.out.println("Get(2): " + lRUCache.get(2) + " (Kỳ vọng: -1)"); // Trả về -1 (đã bị xóa)
        
        lRUCache.put(4, 4); // Vượt dung lượng! Đuổi số 1 đi. cache: {3=3, 4=4}
        
        System.out.println("Get(1): " + lRUCache.get(1) + " (Kỳ vọng: -1)"); // Trả về -1 (đã bị xóa)
        System.out.println("Get(3): " + lRUCache.get(3) + " (Kỳ vọng: 3)");  // Trả về 3
        System.out.println("Get(4): " + lRUCache.get(4) + " (Kỳ vọng: 4)");  // Trả về 4
    }
}
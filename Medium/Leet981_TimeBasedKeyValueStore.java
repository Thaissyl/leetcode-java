package Medium;

import java.util.*;

public class Leet981_TimeBasedKeyValueStore {

    static class TimeMap {
        private static class Data {
            int timestamp;
            String value;

            Data(int timestamp, String value) {
                this.timestamp = timestamp;
                this.value = value;
            }
        }

        private Map<String, List<Data>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(new Data(timestamp, value));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }

            List<Data> history = map.get(key);

            int left = 0;
            int right = history.size() - 1;
            String answer = "";

            while (left <= right) {
                int mid = left + (right - left) / 2;
                Data current = history.get(mid);

                if (current.timestamp <= timestamp) {
                    answer = current.value;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return answer;
        }
    }

    // === HÀM MAIN CHỨA KỊCH BẢN TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 981: TIME BASED KEY-VALUE STORE ===");
        System.out.println("-----------------------------------------------------");

        TimeMap timeMap = new TimeMap();

        // Kịch bản test từ ví dụ LeetCode
        timeMap.set("foo", "bar", 1);

        // Testcase 1: Lấy tại đúng thời điểm timestamp = 1
        String res1 = timeMap.get("foo", 1);
        inKetQua(1, res1, "bar");

        // Testcase 2: Lấy tại thời điểm timestamp = 3 (gần nhất trong quá khứ là 1 ->
        // "bar")
        String res2 = timeMap.get("foo", 3);
        inKetQua(2, res2, "bar");

        // Cập nhật giá trị mới cho "foo" tại timestamp = 4
        timeMap.set("foo", "bar2", 4);

        // Testcase 3: Lấy tại đúng thời điểm timestamp = 4 -> phải ra "bar2"
        String res3 = timeMap.get("foo", 4);
        inKetQua(3, res3, "bar2");

        // Testcase 4: Lấy tại thời điểm timestamp = 5 -> gần nhất quá khứ là 4 ->
        // "bar2"
        String res4 = timeMap.get("foo", 5);
        inKetQua(4, res4, "bar2");

        // Testcase 5: Tìm một key hoàn toàn không tồn tại -> ra ""
        String res5 = timeMap.get("non-exist", 10);
        inKetQua(5, res5, "");
    }

    private static void inKetQua(int testNo, String actual, String expected) {
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Output      : \"" + actual + "\"");
        System.out.println("Expected    : \"" + expected + "\"");
        System.out.println(actual.equals(expected) ? "👉 KẾT QUẢ: CHÍNH XÁC ✅" : "👉 KẾT QUẢ: SAI LẦM ❌");
        System.out.println("-----------------------------------------------------");
    }
}
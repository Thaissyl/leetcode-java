package Medium;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leet853_CarFleet {

    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        double[][] cars = new double[n][2]; 
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Deque<Double> stack = new ArrayDeque<>();
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        for(int i = 0; i < n; i++) {
            double time = (target - cars[i][0]) / cars[i][1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }
        return stack.size();
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE CHUẨN CHỈ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 853: CAR FLEET ===");
        System.out.println("-----------------------------------");

        // Testcase 1: Ví dụ mô tả ở trên
        int target1 = 12;
        int[] pos1 = { 10, 8, 0, 5, 3 };
        int[] speed1 = { 2, 4, 1, 1, 3 };
        inKetQua(1, target1, pos1, speed1, 3);

        // Testcase 2: Độc nhất 1 xe
        int target2 = 10;
        int[] pos2 = { 3 };
        int[] speed2 = { 3 };
        inKetQua(2, target2, pos2, speed2, 1);

        // Testcase 3: Hai xe xuất phát cùng giờ, xe sau chạy nhanh hơn vượt xe trước
        int target3 = 100;
        int[] pos3 = { 0, 2 };
        int[] speed3 = { 30, 10 };
        inKetQua(3, target3, pos3, speed3, 1);
    }

    private static void inKetQua(int testNo, int target, int[] pos, int[] speed, int expected) {
        int actual = carFleet(target, pos, speed);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Output      : " + actual);
        System.out.println("Kỳ vọng     : " + expected);
    }
}
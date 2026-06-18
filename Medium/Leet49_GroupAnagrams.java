package Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet49_GroupAnagrams {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
            }
            String str = Arrays.toString(count);
            ans.putIfAbsent(str, new ArrayList<>());
            ans.get(str).add(s);
        }
        
        return new ArrayList<>(ans.values()); 
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐỂ CHẠY THỬ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 49: GROUP ANAGRAMS ===");

        // Testcase 1: ["eat","tea","tan","ate","nat","bat"]
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        inKetQua(1, strs1);

        // Testcase 2: [""]
        String[] strs2 = {""};
        inKetQua(2, strs2);

        // Testcase 3: ["a"]
        String[] strs3 = {"a"};
        inKetQua(3, strs3);
    }

    // Hàm phụ trợ in kết quả của bạn ra màn hình Terminal
    private static void inKetQua(int testNo, String[] strs) {
        List<List<String>> actual = groupAnagrams(strs);
        System.out.println("Testcase " + testNo + ":");
        System.out.println("Input: " + Arrays.toString(strs));
        System.out.println("Result: " + actual);
        System.out.println("-----------------------------------------");
    }
}
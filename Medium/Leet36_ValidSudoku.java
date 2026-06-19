package Medium;

import java.util.HashSet;
import java.util.Set;

public class Leet36_ValidSudoku {

    // === BẠN TỰ VIẾT CODE GIẢI THUẬT VÀO TRONG HÀM NÀY ===
    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val != '.') {
                    String rowTicket = val + " found in row " + r;
                    String colTicket = val + " found in col " + c;
                    String boxTicket = val + " found in box " + (r / 3) + "-" + (c / 3);
                    if (!seen.add(rowTicket) || !seen.add(colTicket) || !seen.add(boxTicket)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ĐỂ CHẠY THỬ ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 36: VALID SUDOKU ===");

        // Testcase 1: Bàn cờ hợp lệ
        char[][] board1 = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println("Testcase 1: " + isValidSudoku(board1));

        // Testcase 2: Bàn cờ KHÔNG hợp lệ (Hàng đầu tiên có hai số 5)
        char[][] board2 = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '5' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println("Testcase 2: " + isValidSudoku(board2));
    }
}
package Easy;

public class Leet206_ReverseLinkedList {

    // Định nghĩa cấu trúc của một ListNode
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // === BẠN TỰ VIẾT CODE VÀO TRONG HÀM NÀY ===
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // === HÀM MAIN CHỨA CÁC TESTCASE ===
    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ BÀI 206: REVERSE LINKED LIST ===");
        System.out.println("---------------------------------------------");

        // Testcase 1: [1 -> 2 -> 3 -> 4 -> 5]
        ListNode head1 = taoList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Test 1 Ban đầu: ");
        inList(head1);
        ListNode res1 = reverseList(head1);
        System.out.print("Test 1 Đảo ngược: ");
        inList(res1);
        System.out.println("---------------------------------------------");

        // Testcase 2: [1 -> 2]
        ListNode head2 = taoList(new int[]{1, 2});
        System.out.print("Test 2 Ban đầu: ");
        inList(head2);
        ListNode res2 = reverseList(head2);
        System.out.print("Test 2 Đảo ngược: ");
        inList(res2);
        System.out.println("---------------------------------------------");

        // Testcase 3: [] (Danh sách rỗng)
        ListNode head3 = null;
        ListNode res3 = reverseList(head3);
        System.out.print("Test 3 (Rỗng): ");
        inList(res3);
    }

    // Hàm tiện ích tạo LinkedList từ mảng
    private static ListNode taoList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Hàm in LinkedList ra màn hình console
    private static void inList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : " -> null\n"));
            curr = curr.next;
        }
    }
}
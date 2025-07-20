// Question 7: Rotate linked list n steps to the right
// Analogy: Editing a YouTube video by shifting the last few scenes to the front.
// Imagine each node is a scene in the video. Rotating the list is like bringing
// the last 'k' scenes to the beginning of your timeline before publishing.

class ListNode {
    // Each node is a scene or a clip in the video.
    String val; // The actual video content or scene name (e.g., "ID_A01")
    ListNode next; // Points to the next scene that follows in the timeline.
    ListNode(String x) { val = x; }
}

public class Question7_RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        // If the video has no scenes, one scene, or no rotation needed, return as is.
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Count the number of scenes in the video.
        int len = 1;
        ListNode oldTail = head;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            len++;
        }

        // Step 2: Connect the last scene to the first to form a loop.
        // This allows us to "rotate" easily — like dragging the tail of the timeline to the front.
        oldTail.next = head;

        // Step 3: Find the new "cut" point after shifting k scenes.
        // Calculate how many scenes we need to skip from the beginning to find the new tail.
        int steps = len - k % len;

        // Step 4: Move to the new tail (just before the new head).
        ListNode newTail = head;
        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Step 5: The scene after newTail becomes the first in the timeline (new head).
        ListNode newHead = newTail.next;

        // Step 6: Break the loop to finalize the rotation.
        newTail.next = null;

        return newHead; // Final reordered list (video timeline).
    }

    // Utility function to preview the video scenes in order after rotation.
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : " -> null\n"));
            node = node.next;
        }
    }

    public static void main(String[] args) {
        // Create the video scenes (nodes)
        ListNode n1 = new ListNode("ID_A01");
        ListNode n2 = new ListNode("ID_A02");
        ListNode n3 = new ListNode("ID_A03");
        ListNode n4 = new ListNode("ID_A04");
        ListNode n5 = new ListNode("ID_A05");
        ListNode n6 = new ListNode("ID_A06");

        // Build the timeline (linked list)
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;

        // Rotate the video timeline 2 steps to the right
        ListNode rotated = rotateRight(n1, 2);

        System.out.println("Question 7: Rotated video scene order");
        printList(rotated); // Expected: ID_A05 -> ID_A06 -> ID_A01 -> ID_A02 -> ID_A03 -> ID_A04 -> null
    }
}

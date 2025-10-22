class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

public class DoublyLinkedList {
    Node head;

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
        newNode.prev = curr;
    }

    // Delete first occurrence of value
    public void delete(int data) {
        Node curr = head;
        while (curr != null && curr.data != data) curr = curr.next;
        if (curr == null) return; // not found
        if (curr.prev != null) curr.prev.next = curr.next;
        else head = curr.next;
        if (curr.next != null) curr.next.prev = curr.prev;
    }

    // Traverse forward
    public void traverseForward() {
        Node curr = head;
        System.out.print("Forward: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Traverse backward
    public void traverseBackward() {
        Node curr = head;
        if (curr == null) return;
        while (curr.next != null) curr = curr.next;
        System.out.print("Backward: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
        System.out.println();
    }

    // Demo
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert(10); dll.insert(20); dll.insert(30); dll.insert(40);
        dll.traverseForward();   // 10 20 30 40
        dll.traverseBackward();  // 40 30 20 10
        dll.delete(20);
        dll.traverseForward();   // 10 30 40
        dll.traverseBackward();  // 40 30 10
    }
}

# DoublyLinkedList

## 개념
양방향으로 연결된 LinkedList

## 특징
head, tail Node를 가진다.

## 구현
```
class DoublyLinkedList {

    // 노드 클래스
    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head; // 리스트의 첫 번째 노드
    private Node tail; // 리스트의 마지막 노드

    // 맨 뒤 삽입
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) { // 리스트가 비어있을 때
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // 기존 마지막 노드와 연결
            newNode.prev = tail; // 새 노드의 prev를 기존 tail로 연결
            tail = newNode;      // tail을 새 노드로 갱신
        }
    }

    // 맨 앞 삽입
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) { // 리스트가 비어있을 때
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head; // 새 노드 → 기존 head
            head.prev = newNode; // 기존 head ← 새 노드
            head = newNode;      // head 갱신
        }
    }

    // 맨 앞 삭제
    public void removeFirst() {
        if (head == null) return; // 비어있으면 아무 작업 X

        if (head == tail) { // 노드가 하나일 경우
            head = null;
            tail = null;
        } else {
            head = head.next; // head를 다음 노드로 이동
            head.prev = null; // 새로운 head의 prev는 null
        }
    }

    // 맨 뒤 삭제
    public void removeLast() {
        if (tail == null) return;

        if (head == tail) { // 노드가 하나일 경우
            head = null;
            tail = null;
        } else {
            tail = tail.prev; // tail을 이전 노드로 이동
            tail.next = null; // 새로운 tail의 next는 null
        }
    }

    // 전체 출력 (앞에서 뒤로)
    public void printForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 전체 출력 (뒤에서 앞으로)
    public void printBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
}
```

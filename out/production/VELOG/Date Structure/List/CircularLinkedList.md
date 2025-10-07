# 원형 양방향 연결 리스트

## 개념
Index가 0인 Node와 size()-1인 요소가 이어져 있다.

## 특징
> head, tail은 Doubly Llinked List와 동일하다.
> head.prev와 tail.next가 서로를 가리킨다. (head.prev = tail, tail.next = head)

## 구현
```
class CircularDoublyLinkedList {

    // 노드 정의
    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head; // 첫 번째 노드
    private Node tail; // 마지막 노드

    // 맨 뒤 삽입
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) { // 리스트가 비었을 때
            head = newNode;
            tail = newNode;
            head.next = head; // 자기 자신을 가리킴
            head.prev = head;
        } else {
            tail.next = newNode;   // 기존 tail → 새 노드
            newNode.prev = tail;   // 새 노드 ← 기존 tail
            newNode.next = head;   // 새 노드 → head
            head.prev = newNode;   // head ← 새 노드
            tail = newNode;        // tail 갱신
        }
    }

    // 맨 앞 삽입
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) { // 비었을 때
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;   // 새 노드 → 기존 head
            newNode.prev = tail;   // 새 노드 ← tail
            head.prev = newNode;   // 기존 head ← 새 노드
            tail.next = newNode;   // tail → 새 노드
            head = newNode;        // head 갱신
        }
    }

    // 맨 앞 삭제
    public void removeFirst() {
        if (head == null) return;

        if (head == tail) { // 노드가 하나일 경우
            head = null;
            tail = null;
        } else {
            head = head.next;   // 두 번째 노드가 head로
            head.prev = tail;   // 새 head.prev = tail
            tail.next = head;   // tail.next = 새 head
        }
    }

    // 맨 뒤 삭제
    public void removeLast() {
        if (tail == null) return;

        if (head == tail) { // 노드가 하나일 경우
            head = null;
            tail = null;
        } else {
            tail = tail.prev;   // 이전 노드가 tail로
            tail.next = head;   // tail.next = head
            head.prev = tail;   // head.prev = tail
        }
    }

    // 앞에서 뒤로 출력 (원형이라 한 바퀴만 돌도록 제한)
    public void printForward() {
        if (head == null) {
            System.out.println("리스트 비어 있음");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }

    // 뒤에서 앞으로 출력
    public void printBackward() {
        if (tail == null) {
            System.out.println("리스트 비어 있음");
            return;
        }
        Node current = tail;
        do {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        } while (current != tail);
        System.out.println("(tail)");
    }
}
```

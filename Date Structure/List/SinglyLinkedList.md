# 단방향 연결 리스트

## 개념
단방향으로 연결된 리스트이다. (앞 -> 뒤)

## 특징
> Head Node만 있다. (Tail Node 없음)
> Node Class에 Next 필드만 있음. (Prev 필드 없음)

## 구현
```
class SinglyLinkedList {

    // 노드 클래스
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // 첫 번째 노드

    // 맨 앞 삽입
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // 새 노드 → 기존 head
        head = newNode;      // head를 새 노드로 변경
    }

    // 맨 뒤 삽입
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {   // 리스트가 비어있을 때
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) { // 마지막 노드까지 이동
            current = current.next;
        }
        current.next = newNode; // 마지막 노드의 next를 새 노드로 연결
    }

    // 맨 앞 삭제
    public void removeFirst() {
        if (head == null) return; // 리스트가 비어있으면 종료
        head = head.next;         // 두 번째 노드를 head로 지정
    }

    // 맨 뒤 삭제
    public void removeLast() {
        if (head == null) return;        // 리스트가 비었으면 종료
        if (head.next == null) {         // 노드가 하나일 때
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) { // 끝에서 두 번째 노드까지 이동
            current = current.next;
        }
        current.next = null; // 마지막 노드 삭제
    }

    // 리스트 전체 출력
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
```

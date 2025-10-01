# Static Array(정적 배열)

## 개념
동일한 자료형을 정적인,연결된 메모리 안에 저장하는 선형 자료구조

## 특징
> 메모리 크기 증가,감소 불가
> 중간 요소(Element) 추가/삭제 시 해당 Index부터 맨 뒤의 요소들을 한 칸씩 이동하고 추가, 삭제는 역으로 동작
> 사용하는 Index가 0보다 작거나 length를 넘으면 Throw **IndexOutOfBoundException**

## 구현
```
class MyStaticArray {
    private int[] arr;   // 내부 고정 배열
    private int size;    // 현재 원소 개수 (실제로 채워진 원소 수)

    // 생성자
    public MyStaticArray(int capacity) {
        arr = new int[capacity]; // 정적 크기 할당
        size = 0;
    }

    // 삽입 (맨 뒤에 추가)
    public void add(int value) {
        if (size == arr.length) {
            System.out.println("배열이 가득 찼습니다. 삽입 불가!");
            return;
        }
        arr[size] = value;
        size++;
    }

    // 조회 (인덱스로 값 가져오기)
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("잘못된 인덱스: " + index);
        }
        return arr[index];
    }

    // 삭제 (인덱스로 삭제, 뒤 원소들을 앞으로 이동)
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("잘못된 인덱스: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    // 배열 크기(현재 원소 수)
    public int size() {
        return size;
    }

    // 전체 출력
    public void printAll() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
}
```


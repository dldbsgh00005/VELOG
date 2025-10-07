<img width="568" height="264" alt="image" src="https://github.com/user-attachments/assets/156cfcf4-b8aa-4c56-acf5-586a3101c559" />

# 문제상황
StreamAPI의 toList() 메소드는 immutable(불변성) List를 반환한다.
위 이미지와 같이 toList() 이후에 post.setImages를 통해 불변성 리스트를 조작하면 **UnsupportedOperationException** 던짐

# 해결방법
명시적으로 Collectors.toList() 를 호출하자.


# 해결 이미지
<img width="570" height="265" alt="image" src="https://github.com/user-attachments/assets/b2fc741e-1dfe-4141-9aac-37a6fc6b709a" />

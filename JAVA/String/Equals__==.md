Equals : Object에게 상속 받은 메소드, 문자열을 비교할 때 쓴다. (자세한 내용은 아래서.)
== : 참조값(주소값)을 비교할 때 쓴다. Literal String은 **Constant Pool** 에 있다. 그러므로 항상 동일한 주소를 참조한다.
> 단, Constructor 문자열은 Heap 영역에 있으므로 참조값이 다를 수 있다.

# Fields (String.class)
<div>
<img width="635" height="215" alt="image" src="https://github.com/user-attachments/assets/51728675-f79d-430f-9ee4-d1e286b120c2" /> 
<img width="629" height="146" alt="image" src="https://github.com/user-attachments/assets/99188ecb-8ac5-406a-80b6-946e7a9949b2" />
</div>


# Equals : Object의 equals메소드를 Override한다. 
> Object의 equals는 주소, 즉 참조값의 동일성을 확인한다. Literal String이라면 Constant Pool에 있는 값을 참조할테니 항상 주소가 동일하다.

# String.class의 Equals 구현부
<img width="466" height="179" alt="image" src="https://github.com/user-attachments/assets/0237fd83-ab7c-420e-b2c8-7b4a25f12a26" /> <br/>
```
- COMPACT_STRING, coder 필드 기반 검증
- StringLatin1.equals() 메소드 기반 검증
```

## StringLatin1.equals() 구현부
<img width="435" height="255" alt="image" src="https://github.com/user-attachments/assets/37b728f1-a250-49da-b30a-8b54c617ee5c" /> <br/>
```
- byte[] 배열의 길이의 동일성을 검증한다.
- for문을 통해 순환하며 == 기반 Constant Pool 참조값 검증 
```

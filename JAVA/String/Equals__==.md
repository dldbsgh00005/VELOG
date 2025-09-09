```
Equals : Object에게 상속 받은 메소드, 문자열을 비교할 때 쓴다. (자세한 내용은 아래서.)
== : 참조값(주소값)을 비교할 때 쓴다. Literal String은 **Constant Pool** 에 있다. 그러므로 항상 동일한 주소를 참조한다.
# 단, Constructor 문자열은 Heap 영역에 있으므로 참조값이 다를 수 있다.
```
# Fields (String.class)
<div>
<img width="635" height="215" alt="image" src="https://github.com/user-attachments/assets/51728675-f79d-430f-9ee4-d1e286b120c2" /> 
<img width="629" height="146" alt="image" src="https://github.com/user-attachments/assets/99188ecb-8ac5-406a-80b6-946e7a9949b2" />  
<img width="644" height="328" alt="image" src="https://github.com/user-attachments/assets/6aced0dd-db69-4a99-a894-64098a0ed642" />    <br/>

```
value, coder 모두 Constant Pool 일 때만, 즉 Literal String일 때만 VM에 의해 보장 받는다.
compiler가 상수값으로 초기화 해두고, 이후 재계산 하지 않는다.
그러므로 이 것을 Constant Folding이라고 부른다.
이 것은 JIT(Just In Time, Complie 해두고, 코드 실행 시점에 기계어로 변환) 최적화의 기법이다.

coder: Encoding 방식 표기, 0과 1로 표기한다. 0은 Latin1, 1은 UTF16이다.
COMPACT_STRINGS : JVM 최적화를 위한 기법이다. TRUE / FALSE 값을 가지는 Boolean 타입이다.
> JDK8 : 모든 문자열을 char[] 로 저장 -> 모든 char은 2byte -> 무조건 char하나당 2bytes 이므로 메모리 비효율적 사용
> JDK9 : COMPACT_STRINGS=true 일 때 -> Latin1 Encoding으로 충분하면 **coder = 0**, 한글, 일본어, 등 Latin1 Encoding만으로 불충분하면 **coder = 1**
>>  ASCII 코드만 쓰거나, Latin1이 포함하는 북유럽 문자 등만 포함된 문자열일 때 byte[]로 저장해도 됨. 메모리 사용률 50% 감소. 
```

</div>


# Equals : Object의 equals메소드를 Override한다. 
```
Object의 equals는 주소, 즉 참조값의 동일성을 확인한다. Literal String이라면 Constant Pool에 있는 값을 참조할테니 항상 주소가 동일하다.
```

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

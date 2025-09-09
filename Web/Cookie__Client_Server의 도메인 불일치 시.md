# 조건
> Client Domain : nice.com
> Server Doamin : hello.co.kr
> Cookie Attributes : **Secure=true**, **HttpOnly=true**, **MaxAge=0**, **Path=/**, **Domain=hello.co.kr**(**HostOnly**)

# 상황1
Server -> Client / 쿠키를 추가함 

# [상황1], Client가 Server에게 Cookie를 전송하려면?
> withCredentials:true
> 도메인이 불일치 -> Cookie 직접 Parsing 불가 -> Domain + Path에 해당하는 모든 쿠기 전송됨

# 쿠키의 Doamin 속성
> 따로 지정하지 않으면 HostOnly=true 할당 (Server Domain 자동 할당)
> Server Domain을 직접 할당해주면 (Doamin=hello.co.kr / HostOnly=false)

<br/>

> 도메인은 계층 구조를 가짐 (예 : hello.co.kr은 hi.hello.co.kr을 포함 )
> 보안상 명확한 도메인을 지정 권장 (Server Domain만 지정 가능 / Client Domain은 지정할 수 없다.)

# 쿠키 식별자
> Name, Domain, Path
> 세 가지 모두 일치해야 동일한 쿠키로 인식 (문자열이 정확히 일치 시)

# 쿠키 적용 조건
> Domain, Path
> 계층 구조를 따른다. (경로를 포함하면 적용)

# 쿠키 삭제 조건
> Name, Domain, Path
> 문자열이 정확히 일치해야 삭제할 쿠키로 인식

# 쿠키 파싱 조건
> Domain이 동일할 시
> Domain이 계층 구조에 포함될 시



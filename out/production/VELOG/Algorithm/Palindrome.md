# 대칭, 회문
ex) level, wow

# 예시 코드
```
boolean isPalindrome(String s) {
    int l=0, r=s.length()-1;
    while(l<r) {
        if(s.charAt(l)!=s.charAt(r)) return false;
        l++; r--;
    }
    return true;
}

```
+ StringBuilder.class의 reverse() 활용 가능

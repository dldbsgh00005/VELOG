```
# 241031__SpringSecurity.Authentication.UserDetails, userDetailsService

UserDetailsService는 CustomUserDetailsService라는 구현체를 만들어 implements 해준다.

그에 따라 @Override 받을 메소드가 생긴다. ( loadByUsername ) 

loadByUseranme 은 String username을 인자로 받는다.

public UserDetails loadByUsername(String username){

  UserEntity userEntity = userRepository.findByUsername(username);

  if(userEntity == null){
  return null;
  }
  
  UserDetails user = User.builder().username(userEntity.getName()).password(userEntity.getPassword()).build();

  return user;
}


UserDetails 또한 CustomUserDetails에 implements 해준다.

그에 따라 상속받을 메소드들이 많다.

getUsername, getPassword, getAuthority, isExpired 등... 
```

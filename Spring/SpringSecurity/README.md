# Spring Security , Cautions

1. Must use BcryptPasswordEncoder for every single password

2. for Joining User

  - step 1. check whether it is EXISTING USERNAME or not
  - step 2. if it doesn't exist, set USER INFO
  - setp 3. save it to DB

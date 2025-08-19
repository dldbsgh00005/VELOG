# Page란?
- 페이지, 페이지에 출력될 개수, 정렬 기준 등을 받아 조회 하는 방법
- Page, Slice, Cursor 등이 있다.

# Controller 
```
@RequestParam(defaultValue = "title") String keyword,
@RequestParam(defaultValue = "0") int page,
@RequestParam(defaultValue = "10") int size,
@RequestParam(defaultValue = "desc") String sort
```

# Service

```
PageRequest.of(page, Max.min(size, maxSize), Sort.Direction.DESC, field of Entity);
```

# Repository
- @EntityGraph(attributePaths = {"[field of entity]"}) 등으로 N + 1 조회 문제를 피하자.


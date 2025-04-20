```
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    /**
     * 1.명확한 상황 전달
     * 2.예외 처리 비용 감소 -> 비즈니스 로직 가용 시간 증가
     * **/
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeExceptionHandler(RuntimeException ex){
        String[] errMsg = ex.getMessage().split("_");

        String status = errMsg[0];
        String message = errMsg[1];

        return ResponseEntity.badRequest().body(new ErrorBody(status, message));
    }
}
```

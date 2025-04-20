```
@Component
public class Common {
    public static String toString(StatusCode code, Message msg){
        return String.valueOf(code)+"_"+String.valueOf(msg);
    }

    public static ResponseEntity<Object> toResponse(StatusCode code, Object body){
        return ResponseEntity.ok().body(new SuccessBody(code, body));
    }
}
```

```

@Getter
@Setter
public class OrderDetailId implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long order; // OrderDetail.order 의 pk 타입인 Long, 이름 order을 그대로 사용

  private Long product;

  @Override
  public Boolean equals(Object o){
    if(this == o) return true;
    if(!(o instanceof OrderDetailId)) return false;
    OrderDetailsId that = (OrderDetailId) o;
    return Object.equals(order, that.order) &&
           Object.equals(product, that.product);
  }

  @Override
  public int hashCode(){
    return Object.hash(order, product);
  }
}


```

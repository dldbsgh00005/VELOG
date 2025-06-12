# List

## features
- subClass of Collection, Iterators
- ordered collection
- access/search by integer index
- allow duplicate elements
- allow multiple null elements ( and also a null element ) 
- allow pairs of elements e1, e2 ( e1.equals(e2) // true )
- have iterator, listIterator, add, remove, equals, hashCode methods
- if list contains list elements, equals, hashCode methods are not working, so be extremely careful
- some list implementations have restrictions on the type of elements, that may cause NullPointerException or ClassCastException or it may simply return false;
- 

## methods
- int size(); - Integer.MAX_VALUE 보다 클 경우 Integer.MAX_VALUE 반환
- boolean isEmpty(); - element가 존재하면 return true, element가 존재하지 않으면 return false;
- boolean contains(Object o); - element o가 최소 하나 있을 경우 return true; else return false; Object.equals(o, e);
- Iterator<E> iterator(); - return an array containing all elements in the list in proper sequence (from first to last) must return an array even if there is no reference;
- Object[] toArray(); 

# ✅ 2025.06.12 
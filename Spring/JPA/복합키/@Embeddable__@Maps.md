```

Designates a ManyToOne or OneToOne relationship attribute that provides the mapping for an EmbeddedId primary key, an attribute within an EmbeddedId primary key, or a simple primary key of the parent entity. The value element specifies the attribute within a composite key to which the relationship attribute corresponds. If the entity's primary key is of the same Java type as the primary key of the entity referenced by the relationship, the value attribute is not specified.
     Example:
 
     // parent entity has simple primary key
 
     @Entity
     public class Employee {
        @Id long empId;
        String name;
        ...
     } 
 
     // dependent entity uses EmbeddedId for composite key
 
     @Embeddable
     public class DependentId {
        String name;
        long empid;   // corresponds to primary key type of Employee
     }
 
     @Entity
     public class Dependent {
        @EmbeddedId DependentId id;
         ...
        @MapsId("empid")  //  maps the empid attribute of embedded id
        @ManyToOne Employee emp;
     }

```

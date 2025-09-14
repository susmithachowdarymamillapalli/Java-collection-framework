import java.util.HashMap;
import java.util.Objects;

public class HashMapEqualsHashCodeDemo {
    public static void main(String[] args) {
        HashMap<Person,String> map = new HashMap<>();

        Person p1 = new Person("Alice",25);
        Person p2 = new Person("Bob",23);
        Person p3 = new Person("Alice",25);

        //true because the name and id of p1 and p3 are same sine
        // equals() method override
        System.out.println(p1.equals(p3));

        map.put(p1,"Engineer");
        map.put(p2,"Designer");
        map.put(p3,"Manager");
        System.out.println(map);
    }
}

class Person{
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Person(String name, int id){
        this.name=name;
        this.id=id;
    }

    //Override equals method so that the persons with same name and id
    //treated as identical
    @Override
    public boolean equals(Object o) {
       if(this == o) return true;
       if(o==null) return false;
       if(this.getClass() != o.getClass()) return false;
       Person person = (Person) o;
       return this.id == person.getId() && this.getName().equals(person.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    //compute hashcode using name and id both
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}

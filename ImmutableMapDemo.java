import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {
    public static void main(String[] args) {
        Map<String,Integer> mutable = new HashMap<>();
        mutable.put("orange",10);
        mutable.put("apple",20);
        mutable.put("banana",30);

        //creates an immutable map from the hashmap
        Map<String,Integer> immutable = Collections.unmodifiableMap(mutable);
        System.out.println(mutable);

        /*
        changes to mutable map reflects to immutable map as well
        since immutable map is just a wrapper
         */
        mutable.put("grapes",50);

        System.out.println(mutable);
        System.out.println(immutable);

        //modification to immutable map is not allowed
        try {
            immutable.put("grapes", 20);
        }catch(Exception e){
            System.out.println(e);
        }

        //limited to 10 key value pairs
        Map<String,Integer> map = Map.of("John", 100, "Rohn", 99);
        System.out.println(map);

        //modification to immutable map is not allowed
        try {
            map.put("Harry", 94);
        }catch(Exception e) {
            System.out.println(e);
        }

        Map<String,Integer> map2 = Map.ofEntries(Map.entry("John", 100), Map.entry("Rohn", 99));
        System.out.println(map2);

        //modification to immutable map is not allowed
        try {
            map2.put("Harry", 94);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}

/*
output:
------------------------------------------------
{orange=10, banana=30, apple=20}
{orange=10, banana=30, apple=20, grapes=50}
{orange=10, banana=30, apple=20, grapes=50}
java.lang.UnsupportedOperationException
{Rohn=99, John=100}
java.lang.UnsupportedOperationException
{Rohn=99, John=100}
java.lang.UnsupportedOperationException
 */
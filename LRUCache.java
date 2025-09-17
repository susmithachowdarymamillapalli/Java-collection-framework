import java.util.LinkedHashMap;
import java.util.Map;

// A small demo on LRU cache this is currently not thread safe
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private int maxCapacity;

    //create a LinkedHashMap with provided capacity
    //Also, we need access order so the last field should be true in constructor
    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
        this.maxCapacity = capacity;
    }

    @Override
    //Remove the least recently used data whenever capacity exceeds
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxCapacity;
    }

    @Override
    public String toString() {
        return "LRUCache: " + super.toString();
    }

    public static void main(String[] args){
        LRUCache<String,Integer> studentData = new LRUCache<>(3);

        studentData.put("John",99);
        studentData.put("Ron",90);
        studentData.put("Hermoine",100);

        //At this point, capacity of linkedhashmap is 3
        //So, one more request for insertion will call the removeEldestEntry method
        //and remove the key "John" from the map.
        studentData.put("Dumbledore",100);

        System.out.println(studentData); // {Ron=90, Hermoine=100, Dumbledore=100}
    }
}

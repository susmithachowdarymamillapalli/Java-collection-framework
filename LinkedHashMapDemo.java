import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args){
        LinkedHashMap<String, Integer> linkedHashMap = (LinkedHashMap<String, Integer>) createMap(new LinkedHashMap<>());
        HashMap<String,Integer> map = (HashMap<String, Integer>) createMap(new HashMap<>());

        linkedHashMap.get("orange");

        System.out.println("LinkedHashMap....");
        System.out.println(linkedHashMap); // {orange=10, apple=12, guava=20, pineapple=22}

        System.out.println("HashMap....");
        System.out.println(map); // {orange=10, apple=12, pineapple=22, guava=20}

        System.out.println("LinkedHashMap entries with Insertion Order....");
        printMap(linkedHashMap);
        // orange:10
        // apple:12
        // guava:20
        // pineapple:22

        int val = linkedHashMap.getOrDefault("Mango",10);
        System.out.println(val); //10

        linkedHashMap.putIfAbsent("Mango",10);
        linkedHashMap.putIfAbsent("orange",20);
        System.out.println(linkedHashMap); // {orange=10, apple=12, guava=20, pineapple=22, Mango=10}

        accessOrder();
    }

    public static Map<String, Integer> createMap(Map<String, Integer> map){
        map.put("orange",10);
        map.put("apple",12);
        map.put("guava",20);
        map.put("pineapple",22);

        return map;
    }

    public static void printMap(Map<String, Integer> map){
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void accessOrder(){
        //we can use this constructor if we want to maintain order according to the order of accessing
        LinkedHashMap<String, Integer> linkedHashMap = (LinkedHashMap<String, Integer>) createMap(new LinkedHashMap<>(10,0.5f,true));

        linkedHashMap.get("orange");

        System.out.println("LinkedHashMap....");
        System.out.println(linkedHashMap); // {apple=12, guava=20, pineapple=22, orange=10}

        // In access-order LinkedHashMap, recently accessed elements are moved to the end.
        // So the least recently accessed element comes first when iterating.
        System.out.println("HashMap entries with access order....");
        // apple:12
        // guava:20
        // pineapple:22
        // orange:10
        printMap(linkedHashMap);
    }

}



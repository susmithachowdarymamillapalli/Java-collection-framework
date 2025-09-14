import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args)
    {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"Harry");
        map.put(2,"Patrick");
        map.put(3,"Hermoine");

        System.out.println(map); // {1=Harry, 2=Patrick, 3=Hermoine}

        System.out.println(map.get(1)); //Harry

        System.out.println(map.containsKey(1)); //true
        System.out.println(map.containsValue("Patrick")); //true

        //Set which is backed up by the map
        Set<Integer> id_set = map.keySet();

        //Iterate over keys
        for(Integer key : id_set)
            System.out.println(key); // 1 2 3

        id_set.remove(1); //remove key 1
        System.out.println(id_set); // [2,3]

        //This is not allowed since there is no value to pair it with.
        //We get UnsupportedOperationException on this operation
        try {
            id_set.add(1);
        }catch(Exception e){
            System.out.println(e); //java.lang.UnsupportedOperationException
        }

        // Removing key from the set also removes from the map
        System.out.println(map); // {2=Patrick, 3=Hermoine}

        //Add a new key-value pair to map
        map.put(1,"Ron weaselly");
        System.out.println(map); // {1=Ron weaselly, 2=Patrick, 3=Hermoine}

        //Adding an entry to the map will reflect in the set as well
        System.out.println(id_set); //[1, 2, 3]

        //returns a set of Map.Entry<K,V> object
        Set<Map.Entry<Integer,String>> entry_set = map.entrySet();

        //Iterate over the Entry Set to get key and values
        for(Map.Entry<Integer,String> entry : entry_set) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
            //Set a new value to the key 1
            //This is allowed inside iterator since it is not doing any structural modification to Set
            if(entry.getKey() == 1)
                entry.setValue("Black Widow");
        }

        System.out.println(entry_set); // [1=Black Widow, 2=Patrick, 3=Hermoine]

        //Note that the change did to key 1 reflected the map
        System.out.println(map); //{1=Black Widow, 2=Patrick, 3=Hermoine}

        //Add one more entry with key as 4 and value which is same as the one key=2 is mapping to
        map.put(4,"Patrick");
        System.out.println(map); //{1=Black Widow, 2=Patrick, 3=Hermoine, 4=Patrick}

        //return a collection of all values in the map
        Collection<String> values = map.values();
        System.out.println(values); //[Black Widow, Patrick, Hermoine, Patrick]

        //remove "Patrick" from the values since, values() is a live collection backed by the map
        values.remove("Patrick");
        System.out.println(values); // [Black Widow, Hermoine, Patrick]

        //Not supported since values don't have key to pair with
        try {
                values.add("Dumbledore");
        }catch(Exception e){
            System.out.println(e); //java.lang.UnsupportedOperationException
        }

        //Removing a value from the values Collection will remove the first matching key-value pair from map as well
        System.out.println(map); // {1=Black Widow, 3=Hermoine, 4=Patrick}
    }
}

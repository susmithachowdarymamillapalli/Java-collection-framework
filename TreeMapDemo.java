import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        // We can store the reference of TreeMap in a Map instead of SortedMap. But SortedMap have extra methods
       // Map<String, Integer> map = new TreeMap<String, Integer>();
        java.util.SortedMap<String, Integer> map = new TreeMap<>((a,b)->{
            if(a.length()>b.length())
                return 1;
            else if(a.length()<b.length())
                return -1;
            return a.compareTo(b);
        });
        map.put("John",100);
        map.put("Thomas",99);
        map.put("Abhee",98);
        //Null Values are allowed
        map.put("Michael",null);
        map.put("Akshith",null);

        try{
            map.put(null,100); // throw NullPointerException
        }catch(Exception e){
            System.out.println(e);
        }

        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.firstEntry().getValue());
        System.out.println(map.headMap("Akshith"));
        System.out.println(map.tailMap("Akshith"));
        System.out.println(map.subMap("Abhee","Akshith"));
    }
}

/*
java.lang.NullPointerException: Cannot invoke "String.length()" because "a" is null
{John=100, Abhee=98, Thomas=99, Akshith=null, Michael=null}
John
Michael
100
{John=100, Abhee=98, Thomas=99}
{Akshith=null, Michael=null}
{Abhee=98, Thomas=99}
 */

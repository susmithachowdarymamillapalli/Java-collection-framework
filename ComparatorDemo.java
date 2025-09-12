import java.util.*;

public class ComparatorDemo {

    public static void main(String[] args)
    {
        List<String> fruits = Arrays.asList("Apple","Pear","Orange","Watermelon");

        //sort according to default alphabetical order
        Collections.sort(fruits);
        System.out.println(fruits); //[Apple, Orange, Pear, Watermelon]

        //custom comparison
        Collections.sort(fruits, (String s1, String s2)->{
            return s1.length() - s2.length();
        });
        System.out.println(fruits); //[Pear, Apple, Orange, Watermelon]
    }
}

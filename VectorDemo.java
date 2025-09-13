import java.util.Arrays;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args){
        Vector<Integer> vectorDefaultGrowth = new Vector<>(3);
        vectorDefaultGrowth.add(1);
        vectorDefaultGrowth.add(2);
        vectorDefaultGrowth.add(3);
        System.out.println(vectorDefaultGrowth.capacity()); //3
        vectorDefaultGrowth.add(1);
        System.out.println(vectorDefaultGrowth.capacity()); //6 (2*previous capacity)

        Vector<Integer> vectorWithIncrement = new Vector<>(3,5);
        vectorWithIncrement.add(1);
        vectorWithIncrement.add(2);
        vectorWithIncrement.add(3);
        System.out.println(vectorWithIncrement.capacity()); //3
        vectorWithIncrement.add(4);
        System.out.println(vectorWithIncrement.capacity()); //8 (previous capacity + capacityIncrement=5)

        //create a vector with other collections
        Vector<String> movies = new Vector<>(Arrays.asList("HarryPotter","Avengers","GameOfThrones"));
        System.out.println(movies);
    }
}

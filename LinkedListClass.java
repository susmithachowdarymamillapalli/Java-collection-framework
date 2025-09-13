import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListClass {
    public static void main(String[] args) {
        // Create a LinkedList of integers
        LinkedList<Integer> list = new LinkedList<>();

        // Add elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.addLast(40);
        list.addFirst(5);

        System.out.println(list);

        //Remove odd numbers
        list.removeIf(x -> x%2!=0);
        System.out.println(list);

        //creates two LinkedList of Strings and combine them
        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Dog", "Monkey"));
        LinkedList<String> moreAnimals = new LinkedList<>(Arrays.asList("Elephant","Panda"));

        // Add all elements from moreAnimals to animals
        animals.addAll(moreAnimals);
        System.out.println(animals);
    }
}

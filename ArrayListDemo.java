import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(10);

        //ArrayList size
        System.out.println("ArrayList size: " + list.size());

        System.out.println("List list: " + list);

        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));

        for(Integer i : list)
            System.out.println(i);

        System.out.println(list.contains(5));

        //Add new element at index 0
        list.add(0,20);

        //Change the element at index 1 to 30
        list.set(1,30);
        System.out.println(list);
        System.out.println(list.getClass().getName());

        List<Integer> cons_list = List.of(1,2,3,4);
        System.out.println(cons_list);
        //This is not allowed since the list is immutable
        //cons_list.add(0,5);

        List<String> list1 = Arrays.asList("Hello", "world","Hey There");
        System.out.println(list1);
        System.out.println(list1.getClass().getName());
        list1.set(0,"hello");
        System.out.println(list1);
        //Not allowed to re-size the internal array
        //list1.add("new element");

        List<String> list2 = new ArrayList<>(list1);
        System.out.println(list2);
        list2.add("New element");
        System.out.println(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(100);
        list3.add(200);
        list3.add(300);

        //Add all the elements from one collection to other
        list.addAll(list3);
        System.out.println(list);

        //Remove an element at the specified index
        list.remove(1);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
    }
}
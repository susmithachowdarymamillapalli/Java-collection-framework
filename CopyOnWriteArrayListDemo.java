/*        -> CopyOnWriteArrayList means whenver a write operation like adding or removing element happens,
               instead of directly modifying the existing list, a new copy of that list is created and the modification is applied to that copy.
        -> This ensures that other threads reading the list while it's being modified are uneffected.
        -> It is a thread safe variant of ArrayList
        -> Belongs to java.util.concurrent package
        -> Implements List just like ArrayList
        -> Very efficient for read-heavy and write-light use cases
 */

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        // Using CopyOnWriteArrayList instead of ArrayList
        // It allows safe modification (add/remove) while iterating
        List<String> list = new CopyOnWriteArrayList<>();

        // Adding elements to the list
        list.add("Butter");
        list.add("Milk");
        list.add("Eggs");
        list.add("Bread");

        // Printing initial list
        System.out.println("Initial list: " + list);

        // Iterating over the list
        for (String s : list) {
            System.out.println("Reading element: " + s);

            // If the current element is "Butter"
            if (s.equals("Butter")) {
                // Modify the list (add a new element) while iterating
                // Normally, this would throw ConcurrentModificationException in ArrayList
                list.add("Flour");
                System.out.println("Modified the list while reading...");
            }
        }

        // Final state of the list after iteration and modification
        System.out.println("Final list: " + list);
    }
}


// output:
//-------------------------------------------------------
//Initial list: [Butter, Milk, Eggs, Bread]
//Reading element: Butter
//Modified the list while reading...
//Reading element: Milk
//Reading element: Eggs
//Reading element: Bread
//Final list: [Butter, Milk, Eggs, Bread, Flour]
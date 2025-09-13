import java.util.ArrayList;
import java.util.Vector;

public class ThreadSafetyDemoWithVector {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();

        int limit=1000;

        //Thread1
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < limit; i++) {
                list.add(i);
                vector.add(i);
            }

        });

        //Thread2
        Thread thread2 = new Thread(() -> {
            for (int j = 0; j < limit; j++)
            {
                list.add(j);
                vector.add(j);
            }
        });

        thread1.start();
        thread2.start();

        //Let main thread wait till the completion of both thread1 and thread2
        try {
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

        // ArrayList is not thread-safe, so some writes get lost due to race conditions.
        System.out.println("Size of ArrayList: " + list.size()); //Size of ArrayList: 1943

        // Vector is synchronized, so it maintains the expected count.
        System.out.println("Size of Vector: " + vector.size()); //Size of Vector: 2000
    }
}

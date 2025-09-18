import java.lang.ref.WeakReference;

public class GarbageCollection {
    public static void main(String[] args) throws InterruptedException {
        // WeakReference to Phone object (no strong ref exists!)
        WeakReference<Phone> phoneWeakReference = new WeakReference<>(new Phone("Apple","iPhone 16"));

        System.out.println("Initially (referent): " + phoneWeakReference.get());

        System.gc(); // Suggest JVM to run GC
        Thread.sleep(2000); // Give GC some time

        // The referent may be collected by now
        System.out.println("After GC (referent): " + phoneWeakReference.get());

        // The WeakReference object itself still exists
        System.out.println("WeakReference wrapper: " + phoneWeakReference);

        // Now set the WeakReference itself to null
        phoneWeakReference = null;
        System.out.println("After nulling wrapper: " + phoneWeakReference);

        //Strong Reference to Student
        Student student = new Student("Harry","171162");
        System.out.println("Initially Student : " + student);

        //Requesting JVM to do Garbage Collection
        System.gc();

        //Giving some time for JVM to run GC
        Thread.sleep(10000);

        /*This will print the object but it won't be null because
        A strong reference is pointing to the object which will prevent it from GC
        */
        System.out.println("After GC Student: " + student);

        //Nulling the object here
        student = null;
        //Now this is eligible for GC since no reference is pointing to the object
        System.out.println("After nulling Student: " + student);
    }
}

class Phone {
    private String name;
    private String model;

    Phone(String name, String model) {
        this.name = name;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

class Student{
    private String name;
    private String id;

    Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

//OUTPUT
/*
Initially (referent): Phone{name='Apple', model='iPhone 16'}
After GC (referent): null
WeakReference wrapper: java.lang.ref.WeakReference@452b3a41
After nulling wrapper: null
Initially Student : Student{name='Harry', id='171162'}
After GC Student: Student{name='Harry', id='171162'}
After nulling Student: null
 */

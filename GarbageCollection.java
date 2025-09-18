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

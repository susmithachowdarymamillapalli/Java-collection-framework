import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorComparableDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(29);
        list.add(12);
        list.add(51);
        list.add(23);
        list.add(31);

        System.out.println("Before sorting: " + list);
        Collections.sort(list,(a,b)->{
            if(a%10>b%10)
                return 1;
            else
                return -1;
        });
        System.out.println("After sorting: " + list);

        List<Students> studentList = new ArrayList<>();
        studentList.add(new Students("Harry",21));
        studentList.add(new Students("Ron",22));
        studentList.add(new Students("Hermoine",20));
        studentList.add(new Students("Granger",24));
        System.out.println("Student list before sorting: " + studentList);

        Collections.sort(studentList,(s1,s2)->{
            if(s1.getName().length()>s2.getName().length())
                return 1;
            else if(s1.getName().length()<s2.getName().length())
                return -1;
            return 0;
        });
        System.out.println("Student list after sorting: " + studentList);

        List<Animals> animalList = new ArrayList<>();
        animalList.add(new Animals("cat",20));
        animalList.add(new Animals("Rhino",5));
        animalList.add(new Animals("SnowTiger",2));
        animalList.add(new Animals("Kangaroo",30));

        System.out.println("Animal list before sorting: " + animalList);
        Collections.sort(animalList);
        System.out.println("Animal list after sorting: " + animalList);


    }
}

class Students{
    private String name;
    private int age;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Animals implements Comparable<Animals>{
    private String name;
    private int count;

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public Animals(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Animals that) {
        if(this.name.length()>that.name.length())
            return 1;
        else if(this.name.length()<that.name.length())
            return -1;
        else
            return 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

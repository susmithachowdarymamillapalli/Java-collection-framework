import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        //Add elements to stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack); // [1, 2, 3, 4, 5]

        //remove top element
        stack.pop();
        System.out.println(stack); // [1, 2, 3, 4]

        //get top element without removing
        int peek = stack.peek();
        System.out.println(peek); //4

        //get stack size
        System.out.println(stack.size()); //4

        //check if stack is empty
        System.out.println(stack.isEmpty()); //false

        //since stack extends Vector, all Vector methods can be used in Stack as well
        stack.remove(1);
        System.out.println(stack); // [1,3,4]


        //LinkedList as stack
        LinkedList<Integer> list = new LinkedList<>();
        //push() equivalent
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        System.out.println(list);

        //pop() equivalent
        list.removeLast();
        System.out.println(list);

        //LinkedList can be used aa a stack in single threaded env
        //Stack is thread-safe, so we can use stack in multi-thread env. But has legacy design since it extends Vector.
    }
}


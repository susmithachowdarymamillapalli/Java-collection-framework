public class LinkedListImplementation {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.remove( 1);
        linkedList.remove(-1); // Invalid index
        linkedList.remove(100); //Index out of bound....
        linkedList.printList(); // 1 3
        System.out.println("Size of current list is: " + linkedList.size()); //2
    }
}

class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
           return;
        }

        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return;
    }

    public void remove(int index){
        if(head == null) {
            System.out.println("List is empty....");
            return;
        }

        if(index == 0){
            head = head.next;
            return;
        }

        if(index<0){
            System.out.println("Invalid index....");
            return;
        }

        Node temp = head;
        for(int i=0;i<index - 1 && temp!=null;i++){
            temp = temp.next;
        }

        if(temp==null || temp.next==null){
            System.out.println("Index out of bound....");
            return;
        }

        temp.next = temp.next.next;
        return;
    }

    public void printList(){
        Node temp = head;
        System.out.print("List : ");
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int size(){
        int size=0;
        Node temp = head;

        while(temp!=null)
        {
            size++;
            temp = temp.next;
        }
        return size;
    }
}
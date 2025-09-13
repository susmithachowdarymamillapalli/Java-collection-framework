import java.util.concurrent.CopyOnWriteArrayList;

public class NotificationServiceDemo {
    public static void main(String[] args) {
        //create some users
        User user1 = new User("Ram","101");
        User user2 = new User("Ramya","102");
        User user3 = new User("Megha","103");

        //create Notification service
        NotificationService notificationService = new NotificationService();
        notificationService.subscribe(user1);
        notificationService.subscribe(user2);
        notificationService.subscribe(new User("Shyam","104"));

        //Thread1: broadcast the message
        Thread thread1 = new Thread(()->{
            notificationService.broadcast("Welcome...");
        });

        //Thread2: After 2 seconds, a new user subscribes
        Thread thread2 = new Thread(()->{
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            notificationService.subscribe(user3);
        });

        //Start both threads
        thread1.start();
        thread2.start();
    }

}

class NotificationService{
    //Thread-safe list for storing subscribed users
    CopyOnWriteArrayList<User> user_list;

    NotificationService(){
        user_list = new CopyOnWriteArrayList<>();
    }

    public void subscribe(User user){
        System.out.println(user.getName() + " subscribed....");
        user_list.add(user);
    }

    public void unsubscribe(User user){
        System.out.println(user.getName() + " unsubscribed....");
        user_list.remove(user);
    }

    public void broadcast(String message){
        System.out.println("\nBroadcasting this message: " + message);
        for(User user : user_list){
            user.receiveMessage(message);
        }
    }
}

class User{
    private String name;
    private String user_id;


    User(String name, String user_id){
        this.name = name;
        this.user_id = user_id;
    }

    public String getName(){
        return this.name;
    }

    public String getUser_id(){
        return user_id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setUser_id(String user_id){
        this.user_id=user_id;
    }

    public void receiveMessage(String message){
        System.out.println(this.name + " received a message: " + message);
    }

    public String toString(){
        return this.name + "  " + this.user_id;
    }
}
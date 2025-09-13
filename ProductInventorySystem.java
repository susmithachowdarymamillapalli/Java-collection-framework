import java.util.HashMap;

public class ProductInventorySystem {
    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        inventoryManagement.addProduct(new Product("Eggs",7,0,"EGGS100"));
        inventoryManagement.addProduct(new Product("Brown Bread",70.0,30,"BREAD@30"));
        System.out.println(inventoryManagement.getProduct("EGGS100"));
        inventoryManagement.displayAllProducts();
        System.out.println(inventoryManagement.getProduct("EGGS10"));
    }
}

class InventoryManagement{
    private HashMap<String,Product> productList;

    InventoryManagement(){
        productList = new HashMap<>();
    }

    public void  addProduct(Product product){
        productList.put(product.getId(),product);
    }

    public boolean updateQuantity(String id, int new_items){
        Product p =productList.get(id);
        if(p == null){
            System.out.println("Product not found to update quantity");
            return false;
        }
        else{
            int new_quantity = p.getQuantity() + new_items;
            if(new_quantity < 0){
                System.out.println("Quantity cannot be negative. Operation aborted.");
                return false;
            }
            p.setQuantity(new_quantity);
            return true;
        }
    }

    public boolean updatePrice(String id, double price){
        Product p =productList.get(id);
        if(p == null){
            System.out.println("Product not found to update price");
            return false;
        }
        else if(price<0){
            System.out.println("Price cannot be negative. Operation aborted.");
            return false;
        }
        else{
            p.setPrice(price);
            return true;
        }
    }

    public boolean removeProduct(String id){
        Product p =productList.get(id);
        if(p == null){
            System.out.println("Product not found to remove");
            return false;
        }
        else {
            productList.remove(id);
            return true;
        }
    }

    public Product getProduct(String id){
        Product p =productList.get(id);
        if(p == null){
            System.out.println("Product not found to get");
            return null;
        }
        else
            return p;
    }

    public void displayAllProducts(){
        System.out.println("All products:");
        System.out.println("---------------------");
        for(Product product:productList.values()){
            System.out.println(product);
        }
        System.out.println("---------------------");
    }

}

class Product{
    private String name;
    private double price;
    private int quantity;
    private String id;

    Product(String name,double price,int quantity,String id){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getId(){
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

    public void setId(String id){
        this.id=id;
    }

    public String toString(){
        return "PRODUCT_ID:" + id + " NAME:" + name + " PRICE:" + price + " QUANTITY:" + quantity;
    }
}
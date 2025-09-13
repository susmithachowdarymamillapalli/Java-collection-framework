import java.util.ArrayList;
import java.util.List;

public class BookComparatorDemo{
    public static void main(String[] args)
    {
        Book book1 = new Book("Effective Java", "Joshua Bloch", 2018, 4.9);
        Book book2 = new Book("Clean Code", "Robert Martin", 2008, 4.7);
        Book book3 = new Book("Pragmatic Programmer", "Andrew Hunt", 1999, 4.8);
        Book book4 = new Book("Clean Architecture", "Robert Martin", 2017, 4.7);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        //sort according to the yearPublished(newest first)
        books.sort((Book b1, Book b2) -> {
            return b2.getYearPublished() - b1.getYearPublished();
        });

        System.out.println("Sorted according to the year published(newest year first): ");
        for(Book book : books){
            System.out.println(book);
        }

        books.sort((Book b1, Book b2)->{
            if(b2.getRating() - b1.getRating() > 0)
                return 1;
            else if(b2.getRating() - b1.getRating() < 0)
                return -1;
            else
                return 0;
        });

        System.out.println("Sorted according to the ratings: ");
        for(Book book : books){
            System.out.println(book);
        }
    }
}

class Book{
    public String title;
    public String author;
    public int yearPublished;
    public double rating;

    public Book(String title, String author, int yearPublished, double rating)
    {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.rating = rating;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setYearPublished(int yearPublished){
        this.yearPublished = yearPublished;
    }

    public void setRating(double rating){
        this.rating = rating;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getYearPublished(){
        return yearPublished;
    }

    public double getRating(){
        return rating;
    }

    public String toString(){
        return title + " (" + yearPublished + " - " + rating + ")";
    }
}

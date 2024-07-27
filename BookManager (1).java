import java.util.ArrayList;

public class BookManager{

private ArrayList<Book> books = new ArrayList<Book>(); //private for encapsulation.

  public void addBook(Book book) {
      books.add(book);
  }
  
  public void viewBooks() {
      for (Book book : books) {
          System.out.println(book.getTitle() + " by " + book.getAuthor() + ", published by " + book.getPublisher() + " in " + book.getYear());
      }
  }

  public void searchBook(String title) {
      for (Book book : books) {
          if (book.getTitle().equalsIgnoreCase(title)) {
              System.out.println(book.getTitle() + " by " + book.getAuthor() + ", published by " + book.getPublisher() + " in " + book.getYear());
          }
      }
  }
  
  public void removeBook(String title){
    for (Book book : books){
      if (book.getTitle().equalsIgnoreCase(title)){
        books.remove(book);
        System.out.println("Book removed successfully!");
        return;
      }
    }
    System.out.println("Book not found.");
  }
 
}
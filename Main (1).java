import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
  System.out.println("Welcome to Kats's Book Manager!");
  System.out.println("You can add books, view books, and search for books.");
  
  BookManager bookManager = new BookManager();
  
  Scanner scanner = new Scanner(System.in);
    
  while (true){

    System.out.println();
    System.out.println("What would you like to do?");
    System.out.println("1. Add a book");
    System.out.println("2. View books");
    System.out.println("3. Search for a book"); 
    System.out.println("4. Remove a book");
    System.out.println("5. Exit");
    
    int choice = scanner.nextInt();
    scanner.nextLine();

    System.out.print("\033[H\033[2J"); // this works in replit, but not in IntelliJ
    System.out.flush();
    
    if (choice == 1){
      System.out.println("Enter the title of the book:");
      String title = scanner.nextLine();
      System.out.println("Enter the author of the book:");
      String author = scanner.nextLine();
      System.out.println("Enter the publisher of the book:");
      String publisher = scanner.nextLine();
      System.out.println("Enter the year of publication of the book:");
      int year = scanner.nextInt();
      Book book = new Book(title, author, publisher, year);
      bookManager.addBook(book);
      System.out.println("Book added successfully!");
    }
    else if (choice == 2){
      bookManager.viewBooks();
    }
    else if (choice == 3){
      System.out.println("Enter the title of the book you are searching for:");
      String title = scanner.nextLine();
      bookManager.searchBook(title); 
    }
  else if (choice == 4){
    System.out.println("Enter the title of the book you want to remove:");
    String title = scanner.nextLine();
    bookManager.removeBook(title);
    System.out.println("Book removed successfully!");
  }
    else if (choice == 5){
      break;
    }
  
    else{
      System.out.println("Invalid choice. Please try again.");
    }

  }

  scanner.close();
  }

  
}
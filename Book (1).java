public class Book{
  private String title;
  private String author;
  private String publisher;
  private int year;

  public Book(String title, String author, String publisher, int year){
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.year = year;
  }

  public String getTitle(){
    return title;
  }
  public String getAuthor(){
    return author;
  }
  public String getPublisher(){
    return publisher;
  }
   public int getYear(){
    return year;
  }
  public void setTitle(String title){
    this.title = title;
  }
  public void setAuthor(String author){
    this.author = author;
  }
  public void setPublisher(String publisher){
    this.publisher = publisher;
  }
  public void setYear(int year){
    this.year = year;
  }
}
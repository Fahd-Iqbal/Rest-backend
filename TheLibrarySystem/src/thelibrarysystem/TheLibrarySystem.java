

package thelibrarysystem;

import java.sql.SQLException;
import java.util.List;
import pkg487_a1_p1.Author;
import pkg487_a1_p1.Book;
import pkg487_a1_p1.TableDataGateway;


// ev 309 1 pm

/**
 *
 * @author fahd_
 */
public class TheLibrarySystem {
        
    public static TheLibrarySystem theLibrarySystem=null;
    
    TableDataGateway gateway = null;
    
  
 
    public static  TheLibrarySystem getInstance() throws SQLException, ClassNotFoundException{
        if(theLibrarySystem==null){
            theLibrarySystem = new TheLibrarySystem();
            return theLibrarySystem;
        }
        return theLibrarySystem;
    }

    public TheLibrarySystem() throws SQLException, ClassNotFoundException {
        gateway = new TableDataGateway();
    }
     
public  List<Book> showBooks(){

   
    List<Book> books = gateway.ListOfBooks();
    return books;
}


public  void addBook(String t, String d,String i ,String a,String p){
    String firstName = "";
    String lastName = "";
    if(a.split(" ")[0] != null) firstName = a.split(" ")[0];
    if(a.split(" ")[1] != null) lastName = a.split(" ")[1];
    Author author= new Author(firstName,lastName);
    //Author author= new Author("sdfsfsdf","sdfsdf");
    Book b = new Book(t,d,i,p,author);
     gateway.InsertNewBook(b);
        
}

public  String deleteBook(int id){
    try{
         if(gateway.deleteBook(id))
         {
             return "Book deleted";
         }
         else return "Book not found";
           
    }
    catch(Exception e)
    {
        return "book not found";
    }
  
}




public String updateBook(int id, int option, String newVal){

     try{
         Book b = gateway.getInfoById(id);
     
    
     switch(option){
        case 1:
            b.setTitle(newVal);
            break;
                case 2:
            b.setIsbn(newVal);
            break;
        case 3: 
            b.setAuthorFirstName(newVal.split(" ")[0]);
            b.setAuthorLastName(newVal.split(" ")[1]);
            break;
        case 4: 
            b.setDescription(newVal);

            break;        
    
        case 5:
            b.setPublisher(newVal);
            break; 
        
    }
     gateway.updateBook(id, b);
     return "Book Updated";
     }
     catch(Exception e)
     {
         return "Book not found";
     }
    

    
} 



public Book getBookById(int id){
 try{
     Book b = gateway.getInfoById(id);
     return b;
 }
 catch(Exception e)
 {
     return null;
 }
    
 
}

}


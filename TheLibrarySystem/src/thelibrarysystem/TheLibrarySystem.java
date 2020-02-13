

package thelibrarysystem;

import java.util.ArrayList;
import java.util.Scanner;
import pkg487_a1_p1.Author;
import pkg487_a1_p1.Book;


// ev 309 1 pm

/**
 *
 * @author fahd_
 */
public class TheLibrarySystem {
        
    public static TheLibrarySystem theLibrarySystem=null;
    
    
    
    public static  TheLibrarySystem getInstance(){
        if(theLibrarySystem==null){
            theLibrarySystem = new TheLibrarySystem();
            return theLibrarySystem;
        }
        return theLibrarySystem;
    }
    
private ArrayList<Book> list = new ArrayList();
 // if i create a book object Book b = new Book() and i refrence this will i be able to get the information of the books in the program?   
    
public  String showBooks(){
    
//    StringBuilder sb = new StringBuilder();
//    for(int i=0; i<list.size();i++){
//        sb.append(list.get(i).showInfo() +"\n");
//    }
    
    String info= " ";
    for (Book el: list){
       info += el.toString()+"\n";
        
    } 
    return info;
}


public  void addBook(String t, String d,String i ,String a,String p){
    //Author author= new Author(a.split(" ")[0],a.split(" ")[1]);
    Author author= new Author("sdfsfsdf","sdfsdf");
    Book b = new Book(t,d,i,p,author);
     list.add(b);
        
}

public  void deleteBook(int id){
    for(Book el : list){
        if(el.getId()==id){
            list.remove(el);
            
        }
    }
}

public  void getBook(Book b){
    
    
    
    if(list.contains(b)){
        System.out.print(list.get(list.indexOf(b)).showInfo());
        
    }
    else{
        System.out.println("The Book does not exist" + "\n");
    }
}

// can REST hanlde a function like this and if so how can it ?
public String updateBook(int id, int option, String newVal){
    Scanner scannerObject = new Scanner(System.in);
    //System.out.println("\nEnter 1 : modify Title, 2: modify isbn, 3: modify author, 4: modify description 5: modify publisher, 6: modify Author last name, 7: modify all ");
    // want to put a switch case to give option of what the user wants to modify
    //int number = scannerObject.nextInt();
    
     for(Book b : list)   
 if(b.getId()==id){
    
     
     switch(option){
        case 1:
            //System.out.println("Please eneter the updated the title of " +b.getTitle());
            //String newTitle; 
            //newTitle= scannerObject.next();
            b.setTitle(newVal);
            //System.out.println("The updated book Title is: " + b.getTitle());
            //scannerObject.close();
            break;
        
        case 2:
            //System.out.println("Please eneter the updated the Description of " +b.getDescription());
            //String description; 
            //description = scannerObject.next();
            b.setIsbn(newVal);
            //System.out.println("The updated book description is: " + b.getDescription());
            //scannerObject.close();
            break;
            
        case 3: 
          
            //System.out.println("Please eneter the updated the ISBN of " +b.getIsbn());
            //String isbn; 
            //isbn= scannerObject.next();
            b.setAuthorFirstName(newVal.split(" ")[0]);
            //System.out.println("The updated book ISBN is: " + b.getIsbn());
            //scannerObject.close();
            b.setAuthorLastName(newVal.split(" ")[1]);
            break;
            
        case 4: 
            
           // System.out.println("Please eneter the updated the publisher of " +b.getPublisher());
           // String newpublisher;
           // newpublisher= scannerObject.next();
            b.setDescription(newVal);
            //System.out.println("The updated book publisher is: " + b.getPublisher());
            //scannerObject.close();
            break;        
         
            
            
        case 5:
            
      //      System.out.println("Please eneter the updated the first name of the author " +b.getAuthorFirstNAme());
      //      String newAuthorFiratName;
      //      newAuthorFiratName= scannerObject.next();
            b.setPublisher(newVal);
            //System.out.println("The updated first name  is: " + b.getAuthorFirstNAme());
            //scannerObject.close();
            break; 
            
 
                       
            
    }
    
     return "OK";
     
     
     
     
     
     
     
     
 }
    
    
    
  return "Book does not exist";  
    
} 



public Book getBookById(int id){
 for(Book el : list)   
 if(el.getId()==id){
     return el;
 }
 
 
     return null;
    
 
}




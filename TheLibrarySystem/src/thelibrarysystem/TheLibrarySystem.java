

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
        
private static  ArrayList<Book> list = new ArrayList();
    
    
public static void showBooks(){
    
    for(int i=0; i<list.size();i++){
        System.out.println(list.get(i).showInfo() +"\n");
    }
//    for (Object el: list){
//        System.out.println(el.toString()+"\n");
//    }    
}


public static void addBook(Book b){
       
        list.add(b);
}

public static void deleteBook(Book b){
    list.remove(b);
}

public static void getBook(Book b){
    
    
    
    if(list.contains(b)){
        System.out.print(list.get(list.indexOf(b)).showInfo());
        
    }
    else{
        System.out.println("The Book does not exist" + "\n");
    }
}

public static void updateBook(Book b){
    Scanner scannerObject = new Scanner(System.in);
    System.out.println("\nEnter 1 : modify Title, 2: modify Description, 3: modify ISBN, 4: modify Publisher 5: modify Author first name, 6: modify Author last name, 7: modify all ");
    // want to put a switch case to give option of what the user wants to modify
    int number = scannerObject.nextInt();
    switch(number){
        case 1:
            System.out.println("Please eneter the updated the title of " +b.getTitle());
            String newTitle; 
            newTitle= scannerObject.next();
            b.setTitle(newTitle);
            System.out.println("The updated book Title is: " + b.getTitle());
            scannerObject.close();
            break;
        
        case 2:
            System.out.println("Please eneter the updated the Description of " +b.getDescription());
            String description; 
            description = scannerObject.next();
            b.setDescription(description);
            System.out.println("The updated book description is: " + b.getDescription());
            scannerObject.close();
            break;
            
        case 3: 
          
            System.out.println("Please eneter the updated the ISBN of " +b.getIsbn());
            String isbn; 
            isbn= scannerObject.next();
            b.setIsbn(isbn);
            System.out.println("The updated book ISBN is: " + b.getIsbn());
            scannerObject.close();
            break;
            
        case 4: 
            
            System.out.println("Please eneter the updated the publisher of " +b.getPublisher());
            String newpublisher;
            newpublisher= scannerObject.next();
            b.setIsbn(newpublisher);
            System.out.println("The updated book publisher is: " + b.getPublisher());
            scannerObject.close();
            break;        
         
            
            
        case 5:
            
            System.out.println("Please eneter the updated the first name of the author " +b.getAuthorFirstNAme());
            String newAuthorFiratName;
            newAuthorFiratName= scannerObject.next();
            b.setIsbn(newAuthorFiratName);
            System.out.println("The updated first name  is: " + b.getAuthorFirstNAme());
            scannerObject.close();
            break; 
            
            
        case 6:
            
            System.out.println("Please eneter the updated the last name of the author " +b.getAuthorLastNAme());
            String newAuthorLastName;
            newAuthorLastName= scannerObject.next();
            b.setIsbn(newAuthorLastName);
            System.out.println("The updated book last name of author is: " + b.getAuthorLastNAme());
            scannerObject.close();
            break; 
            
        case 7:
            
            System.out.println("change the title");
            String nT= scannerObject.next();
            b.setTitle(nT);
            System.out.println("change the author first name");
            String nf= scannerObject.next();
            b.setAuthorFirstName(nf);
            System.out.println("chage the author last name");
            String nln= scannerObject.next();
            b.setAuthorLastName(nln);
            System.out.println("change the isbn");
            String newIsbn = scannerObject.next();
            b.setIsbn(newIsbn);
            System.out.println("change the description");
            String newD = scannerObject.next(); 
            b.setDescription(newD);
            System.out.println("change the publisher");
            String newP = scannerObject.next(); 
            b.setPublisher(newP);
            scannerObject.close();
            
            
            
            
            
    }
    
    
    
    
    
} // having issues updating and not sure why 

public void getBookById(int id){
 for(Object el : list)   
 if(el.id==id){
     
 }
}

public static void updateIsbn(Book b){
    Scanner scannerObject = new Scanner(System.in);
    String i=scannerObject.next();
    b.setIsbn(i);
}

// -----------------------TESTING METHODS CREATED --------------------------------------------------------------

    public  static void main(String[] args) {
        Book b1 = new Book();
        Author a1= new Author();
        b1.setAuthorFirstName("kiki"); 
        Author a2= new Author("Moon", "cake");
        
        
       Book b2= new Book("4am husle","up late becuase i got distracted","1233","ddddd",a2);
       Author a3 = new Author("Con","U");
       Book b3 = new Book("487>331", "should be studying for 331 but nahh", "2020" , "simba",a3);
       
        // updateIsbn(b1); // it goes back to normal it is not saving the update for some reason in memory 
      addBook(b1);
      addBook(b2);
      addBook(b3);
      showBooks();
      // getBook(b1);
       //getBook(b3);
       updateBook(b1);
       
       showBooks();
       //b2.setAuthorFirstName("fred");
       //System.out.println(b2.toString());
    }

















}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg487_a1_p1;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fahd_
 */
@XmlRootElement()
public class Book {
    private int id;;
    private static int count=0;
    private String title; 
    private String description; 
    private String isbn; 
    private String publisher; 
    private Author author; 
    
    
    Author a1 = new Author("you","and us");
    public Book(){
        this.id=count++;
        this.title= "Thank You Kobe ";
        this.description = "a book to that goes into how kobe helped shapped the lives of people";
        this.isbn = "100 ";
        this.publisher = "your boy ";
        this.author = a1; // like this because its an object
    }
    
    public Book(String title, String description, String isbn, String publisher, Author author){
        this.id=count++;
        this.title= title; 
        this.description=description; 
        this.isbn= isbn; 
        this.publisher=publisher; 
        this.author=author; 
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthorFirstNAme() {
        return author.getFirstName();
    }

    public void setAuthorFirstName(String name) {
        this.author.setFirstName(name);
    }
    
    
    public String getAuthorLastNAme(){
        return this.author.getLastName();
    }
    
    public void setAuthorLastName(String name){
        this.author.setLastName(name);
    }
   
    public String showInfo(){
        
        return "the title is " + title + " the author is : " + author.getFirstName() + ", " + author.getLastName() + ". The discription is :" + description + ". The isbn: " +isbn + " the published by " + publisher; 
    }
    
    public String toString(){
            return "the title is " + title + " the author is : " + author.getFirstName() + ", " + author.getLastName() + ". The discription is :" + description + ". The isbn: " +isbn + " the published by " + publisher; 

}
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}

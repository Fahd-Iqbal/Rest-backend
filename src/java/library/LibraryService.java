/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import pkg487_a1_p1.Book;
import thelibrarysystem.TheLibrarySystem;

/**
 * REST Web Service
 *
 * @author fahd_
 */
@Path("library")
public class LibraryService {

    @Context
    private UriInfo context;
    // check if it not null 
    // then return instance 
    // recive context as argument is not null return otherwise always call null

    TheLibrarySystem sys = TheLibrarySystem.getInstance();

    
    /**
     * Creates a new instance of LibraryService
     */
    
    Book b = new Book();
    
    
    
    
    
    public LibraryService() {
    }

    @GET
    @Path("/showbooks")
    @Produces(MediaType.TEXT_PLAIN)
    public String showBooks(){
     
      
        return sys.showBooks();
    }
    
    
    @GET
    @Path("/getabook")
    @Produces (MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String getBook(@PathParam("id")int id){
        try{
           return sys.getBookById(id).toString();
        }
        catch(Exception e){
            return "The Book does not exist";
            
        }
    }
    
    
    
    @POST
    @Path("/addbook")
    @Produces (MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public  void addBook(@FormParam("title") String t, @FormParam("description") String d, @FormParam("isbn") String i, @FormParam("author") String a, @FormParam("publisher") String p){
        
       sys.addBook(t,d,i,a,p);
    }
    
    @DELETE
    @Path("/deletebook/{id}")
    @Produces (MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String deleteBook(int id){
        try{
            sys.deleteBook(id);
            return "Book is deleted";
        }catch(Exception e){
            return ("The Book you entred does not exist");
        }
    }
    
    
    
   @PUT
   @Path("/updatebook")
   @Produces(MediaType.TEXT_PLAIN)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updateBook(@FormParam("id") int id, @FormParam("Attribute") int option, @FormParam("NewValue") String newValue){
        try{
        sys.updateBook(id, option, newValue);
        return "Book has been updated";
            
        }catch(Exception e){
            return "Book does not exist";
        }
        
    }


}

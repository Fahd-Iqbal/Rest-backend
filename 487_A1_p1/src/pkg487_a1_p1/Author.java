/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg487_a1_p1;

/**
 *
 * @author fahd_
 */
public class Author {
    
   private String firstName; 
   private String lastName;

    public Author(){
       this.firstName = " ";
       this.lastName = " ";
   }
   
   public Author(String firstName, String lastName){
       this.firstName= firstName;
       this.lastName = lastName;
   }
   
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
   
   
   
  
   
   
    
}

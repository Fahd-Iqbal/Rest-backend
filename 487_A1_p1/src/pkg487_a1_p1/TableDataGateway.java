/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg487_a1_p1;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fahd_
 */
public class TableDataGateway {
    
    
    private Connection conn = null;

    private String user = "root";
    private String pass = "password";
    private String host = "jdbc:mysql://localhost:3306/sys?autoReconnect=true&useSSL=false";
    
    //****************************************************************************************************
    //****************************************************************************************************
    public TableDataGateway() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection(host, user, pass);
        
    }
    
    public List<Book> ListOfBooks(){
       List<Book> booksList = new ArrayList<>();
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM book");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    String isbn = rs.getString("isbn");
                    Author author = new Author(rs.getString("author_first_name"), rs.getString("author_last_name"));
                    String publisher = rs.getString("publisher");
                    
                    Book myBook = new Book(id, title, description, isbn, publisher, author);             
                    booksList.add(myBook);
                }
                return booksList;
            } catch (SQLException e) {
                return null;
            } 
        
    }
    
    
    public Book getInfoById(int id){
                   Book myBook = null;
            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM book WHERE id=?")) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        int id2 = rs.getInt("id");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    String isbn = rs.getString("isbn");
                    Author author = new Author(rs.getString("author_first_name"), rs.getString("author_last_name"));
                    String publisher = rs.getString("publisher");
                    
                    myBook = new Book(id2, title, description, isbn, publisher, author);
                        
                    }
                    return myBook;
                }
            } catch (SQLException e) {
                return null;
            }
        
        
        
        
    }

    
    public int InsertNewBook(Book myBook) {
                try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO book (id, title, description, isbn, author_first_name, author_last_name, publisher) Values(?, ?, ?, ?, ?, ?, ?)")) {
                stmt.setInt(1, myBook.getId());
                stmt.setString(2, myBook.getTitle());
                stmt.setString(3, myBook.getDescription());
                stmt.setString(4, myBook.getIsbn());
                stmt.setString(5, myBook.getAuthorFirstName());
                stmt.setString(6, myBook.getAuthorLastName());
                stmt.setString(7, myBook.getPublisher());
                stmt.executeUpdate();
                return myBook.getId();
            } catch (SQLException e) {
                return -1;
            }
        }
    
    
    
     public boolean updateBook(int id, Book myBook){

            try (PreparedStatement stmt = conn.prepareStatement("UPDATE book SET title=?, description=?, isbn=?, author_first_name=?, author_last_name=?, publisher=? WHERE id=?")) {
                stmt.setString(1, myBook.getTitle());
                stmt.setString(2, myBook.getDescription());
                stmt.setString(3, myBook.getIsbn());
                stmt.setString(4, myBook.getAuthorFirstName());
                stmt.setString(5, myBook.getAuthorLastName());
                stmt.setString(6, myBook.getPublisher());
                stmt.setInt(7, id);
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                return false;
            }
        }
     
     
     
     public boolean deleteBook(int id){
         try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM book");
                String  isbn = "";
                while (rs.next()) {
                    isbn = rs.getString("isbn");
                     
                } 
                if(isbn.equals("ffff"))
                {return false;}
               
            }catch (SQLException e) {
                return false;}
         
          try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM book WHERE id=?")) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                return false;
            }
         
     } 
     
      public boolean deleteAll(){
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("DELETE FROM book");
                return true;
            } catch (SQLException e) {
                return false;
            }
      }
     
     
     
     
}
    
    
    
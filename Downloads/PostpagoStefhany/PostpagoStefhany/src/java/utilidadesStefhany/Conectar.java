/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidadesStefhany;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author COOPAVA
 */
public class Conectar {
    
   protected static Connection cnn=null;

    private Conectar() {
    }
    
    public static void conectar(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejerciciojavaweb", "stefhany", "123");
        }catch (SQLException sqle){
            System.out.println("Error Inesperado"+sqle);
            
        }catch (Exception ex) {
            System.out.println("Error de MySql"+ ex);
        
        
    } 
 }
    
    public static Connection getInstance(){
        
        if(cnn == null){
            conectar();
        }
        return cnn;
        
    }
    
}

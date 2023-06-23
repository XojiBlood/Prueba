package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    private final String bd = "libreria";
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String user = "root";
    private final String pass = "";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private Connection cx;

    public Conexion() {
    }
    
    public Connection conectar(){
        
        try {
            Class.forName(driver);
            cx=DriverManager.getConnection(url+bd, user, pass);
            System.out.println("Se conecto a la base de datos "+bd);
        
        } catch (ClassNotFoundException | SQLException ex) {
        
            System.out.println("No se logro conectar a la base de datos "+bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
 public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.conectar();
    }    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author saave
 */
public class ConsultasLibreria extends Conexion{
    
    public boolean registrar(LibreriasGet_Set Lib){
        
        PreparedStatement ps = null;
        Connection cx = conectar();
        
        String sql = "INSERT INTO socios (Nombre, Direccion, Telefono, Correo_Electronico, Estado) VALUES(?,?,?,?,?,?)";
        
        try{
            
            ps = cx.prepareStatement(sql);
            ps.setString(1, Lib.getNombre());
            ps.setString(2, Lib.getDireccion());
            ps.setInt(3, Lib.getTelefono());
            ps.setString(4, Lib.getCorreo());
            ps.setString(5, Lib.getEstado());
            ps.execute();
            return true;
        } catch(SQLException e){
            
            System.err.println(e);
            return false;
        } finally {
            try {
                cx.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
            
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ah10.dao;

import Ah10.util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class Fpg_Importaponto_AhgoraDao {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;    

    public Fpg_Importaponto_AhgoraDao() throws Exception {
        // TODO Auto-generated constructor stub
        conn = Database.getConnection();
        if (conn == null){
                throw new Exception(getClass().getName() + ": null connection.");
        }
        this.conn = conn;
    }
    
    public void Importar(String registro, String nro_rep) throws SQLException{
        String query = "select fpg_importaponto_ahgora(?,'conexaorep',null,?);";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, registro);
        stmt.setString(2, nro_rep);
        
        rs = stmt.executeQuery();
        if(rs.next()){
            System.out.println(">>>>> Importado");
        }
    }
    
}

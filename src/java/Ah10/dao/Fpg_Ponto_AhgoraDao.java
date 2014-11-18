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
public class Fpg_Ponto_AhgoraDao {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    public Fpg_Ponto_AhgoraDao() throws Exception {
        // TODO Auto-generated constructor stub
        conn = Database.getConnection();
        if (conn == null){
                throw new Exception(getClass().getName() + ": null connection.");
        }
        this.conn = conn;
    }
    public Integer UltimoNsr(String nro_rep) throws SQLException{
        Integer rNsr = 0;
        
        String query = "select nsr + 1  as nsr from fpg_ponto_ahgora where nro_rep = ? order by nsr desc limit 1 ";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, nro_rep);
        rs = stmt.executeQuery();
        if(rs.next()){
            rNsr = rs.getInt("nsr");
        }
        
        return rNsr;
    }
    
}

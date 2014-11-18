/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ah10.dao;

import Ah10.comandos.Funcionario;
import Ah10.util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class Fpg_Ponto_DadosAhgoraDao {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

    public Fpg_Ponto_DadosAhgoraDao() throws Exception {
        conn = Database.getConnection();
        if (conn == null){
                throw new Exception(getClass().getName() + ": null connection.");
        }
        this.conn = conn;        
    }
    
    public Funcionario getDados(int id_parceiro) throws SQLException{
        Funcionario vo = new Funcionario();
        String query = "select * from fpg_ponto_dadosahgora "
                + " inner join fpg_cadfunc using (id_parceiro) "
                + " where id_parceiro = ?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, id_parceiro);
        
        rs = stmt.executeQuery();
        if (rs.next()){
            vo.setNome(rs.getString("nmfuncionario"));
            vo.setId(rs.getString("id_parceiro"));
            vo.setBiodados(rs.getString("biodados"));
            //vo.setMifaredado(rs.getString("mifare"));
            vo.setPasswd(rs.getString("passwd"));
            vo.setTempo(rs.getInt("tempo"));
            vo.setCodbarras(rs.getString("codbarras"));
            vo.setPis(rs.getString("pis"));
        }
        
        return vo;
    }
}

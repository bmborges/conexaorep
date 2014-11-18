/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ah10.dao;

import Ah10.comandos.CmdCfg_Funcionario;
import Ah10.comandos.CmdExclui_Funcionario;
import Ah10.comandos.CmdPede_Dados_PIS;
import Ah10.comandos.Funcionario;
import Ah10.comandos.Pis;
import Ah10.util.Database;
import Ah10.vo.Fpg_Ponto_CmdPendenteVO;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class Fpg_Ponto_CmdPendenteDao {
    Gson gson = new Gson();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;    

    public Fpg_Ponto_CmdPendenteDao() throws Exception {
        conn = Database.getConnection();
        if (conn == null){
                throw new Exception(getClass().getName() + ": null connection.");
        }
        this.conn = conn;
    }
    public static void main(String[] args) throws Exception {
        Fpg_Ponto_CmdPendenteDao dao = new Fpg_Ponto_CmdPendenteDao();
        List l = new ArrayList<Fpg_Ponto_CmdPendenteVO>();
        l = dao.VerificaCmdPendente("10000270001822");
        for (int i = 0; i < l.size(); i++) {
            Fpg_Ponto_CmdPendenteVO vo = (Fpg_Ponto_CmdPendenteVO) l.get(i);
            if (vo.getNmcomando().equalsIgnoreCase("exclui_funcionario")){
                dao.exclui_funcionario(vo);
            } else if (vo.getNmcomando().equalsIgnoreCase("cfg_funcionario")){
                dao.cfg_funcionario(vo);
            } else if (vo.getNmcomando().equalsIgnoreCase("pede_dados_pis")){
                dao.pede_dados_pis(vo);                
            }
        }
    }
    
    public List VerificaCmdPendente(String nro_rep) throws SQLException{
        List l = new ArrayList<Fpg_Ponto_CmdPendenteVO>();
        
        String query = "select distinct nmcomando from fpg_ponto_cmdpendente where upper(pendente) = 'V' and nro_rep = ?";
        stmt = conn.prepareStatement(query);
        
        stmt.setString(1, nro_rep);
        rs = stmt.executeQuery();
        
        while (rs.next()){
            Fpg_Ponto_CmdPendenteVO vo = new Fpg_Ponto_CmdPendenteVO();
//            vo.setIdcmdpendente(rs.getInt("idcmdpendente"));
//            vo.setIdparceiro(rs.getInt("idparceiro"));
            vo.setNmcomando(rs.getString("nmcomando"));
//            vo.setPis(rs.getString("pis"));
            vo.setNro_rep(nro_rep);
            l.add(vo);
        }
        return l;
    }
    public CmdExclui_Funcionario exclui_funcionario(Fpg_Ponto_CmdPendenteVO vo) throws SQLException{
        
        CmdExclui_Funcionario cmd = new CmdExclui_Funcionario();
        String query = "select * from fpg_ponto_cmdpendente where upper(pendente) = 'V' and nro_rep = ? and nmcomando = ?";
        String qUpdate = "update fpg_ponto_cmdpendente set pendente = 'F' where id_cmdpendente = ?";
        
        stmt = conn.prepareStatement(query);
        stmt.setString(1, vo.getNro_rep());
        stmt.setString(2, vo.getNmcomando());
        
        rs = stmt.executeQuery();
        
        ArrayList<Pis> aPis = new ArrayList<Pis>();
        while(rs.next()){
            Pis pis = new Pis();
            pis.setPis(rs.getString("pis"));
            aPis.add(pis);
            
            stmt = conn.prepareStatement(qUpdate);
            stmt.setInt(1, rs.getInt("id_cmdpendente"));
            stmt.executeUpdate();
            
        }
        cmd.setFuncionarios(aPis);
        
        System.out.println(gson.toJson(cmd));
        
        return cmd;
    }
    public CmdCfg_Funcionario cfg_funcionario(Fpg_Ponto_CmdPendenteVO vo) throws SQLException, Exception{
        
        ArrayList<Funcionario> aFuncionario = new ArrayList<Funcionario>();
        Fpg_Ponto_DadosAhgoraDao dao = new Fpg_Ponto_DadosAhgoraDao();
        CmdCfg_Funcionario cmd = new CmdCfg_Funcionario();
        
        String query = "select * from fpg_ponto_cmdpendente where upper(pendente) = 'V' and nro_rep = ? and nmcomando = ?";
        String qUpdate = "update fpg_ponto_cmdpendente set nmcomando = 'pede_dados_PIS' where id_cmdpendente = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, vo.getNro_rep());
        stmt.setString(2, vo.getNmcomando());
        
        rs = stmt.executeQuery();
        
        while(rs.next()){
            aFuncionario.add(dao.getDados(rs.getInt("id_parceiro")));
            
            stmt = conn.prepareStatement(qUpdate);
            stmt.setInt(1, rs.getInt("id_cmdpendente"));
            stmt.executeUpdate();
        }
        cmd.setFuncionarios(aFuncionario);
        
        System.out.println(gson.toJson(cmd));
        
        return cmd;
    }
    public CmdPede_Dados_PIS pede_dados_pis(Fpg_Ponto_CmdPendenteVO vo) throws SQLException, Exception{
        
        ArrayList<Funcionario> aFuncionario = new ArrayList<Funcionario>();
        Fpg_Ponto_DadosAhgoraDao dao = new Fpg_Ponto_DadosAhgoraDao();
        CmdPede_Dados_PIS cmd = new CmdPede_Dados_PIS();
        
        String query = "select * from fpg_ponto_cmdpendente "
                + " inner join fpg_cadfunc using (id_parceiro)"
                + " where upper(pendente) = 'V' and nro_rep = ? and nmcomando = ? limit 1";
        String qUpdate = "update fpg_ponto_cmdpendente set pendente = 'F' where id_cmdpendente = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, vo.getNro_rep());
        stmt.setString(2, vo.getNmcomando());
        
        rs = stmt.executeQuery();
        
        while(rs.next()){
            cmd.setPis(rs.getString("pis"));
            
            stmt = conn.prepareStatement(qUpdate);
            stmt.setInt(1, rs.getInt("id_cmdpendente"));
            stmt.executeUpdate();
        }
        
        System.out.println(gson.toJson(cmd));
        
        return cmd;
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ah10.vo;

import java.sql.Timestamp;

/**
 *
 * @author bruno
 */
public class Fpg_Ponto_CmdPendenteVO {
private Integer idcmdpendente;
private Integer id_parceiro;
private Timestamp dt_sistema;
private String nmoperador;
private String nmcomando;
private String pendente;
private String pis;
private String nro_rep;
private Timestamp dt_agendada;

    /**
     * @return the idcmdpendente
     */
    public Integer getIdcmdpendente() {
        return idcmdpendente;
    }

    /**
     * @param idcmdpendente the idcmdpendente to set
     */
    public void setIdcmdpendente(Integer idcmdpendente) {
        this.idcmdpendente = idcmdpendente;
    }

    /**
     * @return the idparceiro
     */
    public Integer getId_parceiro() {
        return id_parceiro;
    }

    /**
     * @param idparceiro the idparceiro to set
     */
    public void setId_parceiro(Integer id_parceiro) {
        this.id_parceiro = id_parceiro;
    }

    /**
     * @return the dt_sistema
     */
    public Timestamp getDt_sistema() {
        return dt_sistema;
    }

    /**
     * @param dt_sistema the dt_sistema to set
     */
    public void setDt_sistema(Timestamp dt_sistema) {
        this.dt_sistema = dt_sistema;
    }

    /**
     * @return the nmoperador
     */
    public String getNmoperador() {
        return nmoperador;
    }

    /**
     * @param nmoperador the nmoperador to set
     */
    public void setNmoperador(String nmoperador) {
        this.nmoperador = nmoperador;
    }

    /**
     * @return the nmcomando
     */
    public String getNmcomando() {
        return nmcomando;
    }

    /**
     * @param nmcomando the nmcomando to set
     */
    public void setNmcomando(String nmcomando) {
        this.nmcomando = nmcomando;
    }

    /**
     * @return the pendente
     */
    public String getPendente() {
        return pendente;
    }

    /**
     * @param pendente the pendente to set
     */
    public void setPendente(String pendente) {
        this.pendente = pendente;
    }

    /**
     * @return the pis
     */
    public String getPis() {
        return pis;
    }

    /**
     * @param pis the pis to set
     */
    public void setPis(String pis) {
        this.pis = pis;
    }

    /**
     * @return the nro_rep
     */
    public String getNro_rep() {
        return nro_rep;
    }

    /**
     * @param nro_rep the nro_rep to set
     */
    public void setNro_rep(String nro_rep) {
        this.nro_rep = nro_rep;
    }

    /**
     * @return the dt_agendada
     */
    public Timestamp getDt_agendada() {
        return dt_agendada;
    }

    /**
     * @param dt_agendada the dt_agendada to set
     */
    public void setDt_agendada(Timestamp dt_agendada) {
        this.dt_agendada = dt_agendada;
    }    
}

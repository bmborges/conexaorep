/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ah10.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author bruno
 */
public class Fpg_Ponto_AhgoraVO implements Serializable{

private Integer id_ponto_ahgora;
private Integer id_empresa;
private String nro_rep;
private Timestamp dt_sistema;
private Timestamp dt_registro;
private String nmoperador;
private Integer id_parceiro;
private Integer nsr;

    /**
     * @return the id_ponto_ahgora
     */
    public Integer getId_ponto_ahgora() {
        return id_ponto_ahgora;
    }

    /**
     * @param id_ponto_ahgora the id_ponto_ahgora to set
     */
    public void setId_ponto_ahgora(Integer id_ponto_ahgora) {
        this.id_ponto_ahgora = id_ponto_ahgora;
    }

    /**
     * @return the id_empresa
     */
    public Integer getId_empresa() {
        return id_empresa;
    }

    /**
     * @param id_empresa the id_empresa to set
     */
    public void setId_empresa(Integer id_empresa) {
        this.id_empresa = id_empresa;
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
     * @return the dt_registro
     */
    public Timestamp getDt_registro() {
        return dt_registro;
    }

    /**
     * @param dt_registro the dt_registro to set
     */
    public void setDt_registro(Timestamp dt_registro) {
        this.dt_registro = dt_registro;
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
     * @return the id_parceiro
     */
    public Integer getId_parceiro() {
        return id_parceiro;
    }

    /**
     * @param id_parceiro the id_parceiro to set
     */
    public void setId_parceiro(Integer id_parceiro) {
        this.id_parceiro = id_parceiro;
    }

    /**
     * @return the nsr
     */
    public Integer getNsr() {
        return nsr;
    }

    /**
     * @param nsr the nsr to set
     */
    public void setNsr(Integer nsr) {
        this.nsr = nsr;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ah10.comandos;

/**
 *
 * @author bruno
 */
public class Funcionario {
    private String nome = "";
    private String codbarras = "";
    private String[] mifaredado = new String[]{};
    private Integer tempo = null;
    private String biodados = "";
    private String id = "";
    private String pis = "";
    private String passwd = "";

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the codbarras
     */
    public String getCodbarras() {
        return codbarras;
    }

    /**
     * @param codbarras the codbarras to set
     */
    public void setCodbarras(String codbarras) {
        this.codbarras = codbarras;
    }

    /**
     * @return the mifaredado
     */
    public String[] getMifaredado() {
        return mifaredado;
    }

    /**
     * @param mifaredado the mifaredado to set
     */
    public void setMifaredado(String[] mifaredado) {
        this.mifaredado = mifaredado;
    }

    /**
     * @return the tempo
     */
    public Integer getTempo() {
        return tempo;
    }

    /**
     * @param tempo the tempo to set
     */
    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    /**
     * @return the biodados
     */
    public String getBiodados() {
        return biodados;
    }

    /**
     * @param biodados the biodados to set
     */
    public void setBiodados(String biodados) {
        this.biodados = biodados;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }    
}

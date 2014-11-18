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
    private String Nome = "";
    private String CodBarras = "";
    private String MiFareDado = "";
    private Integer Tempo = null;
    private String BioDados = "";
    private String ID = "";
    private String PIS = "";
    private String Passwd = "";

    /**
     * @return the nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the codbarras
     */
    public String getCodbarras() {
        return CodBarras;
    }

    /**
     * @param codbarras the codbarras to set
     */
    public void setCodbarras(String CodBarras) {
        this.CodBarras = CodBarras;
    }

    /**
     * @return the mifaredado
     */
    public String getMifaredado() {
        return MiFareDado;
    }

    /**
     * @param mifaredado the mifaredado to set
     */
    public void setMifaredado(String mifaredado) {
        this.MiFareDado = mifaredado;
    }

    /**
     * @return the tempo
     */
    public Integer getTempo() {
        return Tempo;
    }

    /**
     * @param tempo the tempo to set
     */
    public void setTempo(Integer tempo) {
        this.Tempo = tempo;
    }

    /**
     * @return the biodados
     */
    public String getBiodados() {
        return BioDados;
    }

    /**
     * @param biodados the biodados to set
     */
    public void setBiodados(String biodados) {
        this.BioDados = biodados;
    }

    /**
     * @return the id
     */
    public String getId() {
        return ID;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.ID = id;
    }

    /**
     * @return the pis
     */
    public String getPis() {
        return PIS;
    }

    /**
     * @param pis the pis to set
     */
    public void setPis(String pis) {
        this.PIS = pis;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return Passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.Passwd = passwd;
    }    
}

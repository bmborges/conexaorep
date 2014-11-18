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
public class CmdPede_Dados_PIS {
    String cmd = null;
    private String PIS = "";

    public CmdPede_Dados_PIS() {
        this.cmd = "pede_dados_PIS";
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
    
    
}

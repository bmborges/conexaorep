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
public class CmdAfd {
    private String cmd = null;
    private Integer nsr_ini = null;
    private Integer nsr_fim = null;    

    public CmdAfd() {
        this.cmd = "AFD";
    }
    /**
     * @return the cmd
     */
    public String getCmd() {
        return cmd;
    }

    /**
     * @param cmd the cmd to set
     */
    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    /**
     * @return the nsr_ini
     */
    public Integer getNsr_ini() {
        return nsr_ini;
    }

    /**
     * @param nsr_ini the nsr_ini to set
     */
    public void setNsr_ini(Integer nsr_ini) {
        this.nsr_ini = nsr_ini;
    }

    /**
     * @return the nsr_fim
     */
    public Integer getNsr_fim() {
        return nsr_fim;
    }

    /**
     * @param nsr_fim the nsr_fim to set
     */
    public void setNsr_fim(Integer nsr_fim) {
        this.nsr_fim = nsr_fim;
    }
    
}

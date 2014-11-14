/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ah10.comandos;

/**
 *
 * @author root
 */
public class CmdDorme {
    private String cmd;
    private Integer tempo = null;

    public CmdDorme() {
        this.cmd = "dorme";
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
}

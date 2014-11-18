/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ah10.comandos;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class CmdCfg_Funcionario {
    private String cmd = null;
    private ArrayList<Funcionario> funcionarios = null;

    public CmdCfg_Funcionario() {
        this.cmd = "cfg_funcionario";
    }

    /**
     * @return the funcionarios
     */
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }    
}

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
    private ArrayList<Funcionario> Funcionarios = null;

    public CmdCfg_Funcionario() {
        this.cmd = "cfg_funcionarios";
    }

    /**
     * @return the funcionarios
     */
    public ArrayList<Funcionario> getFuncionarios() {
        return Funcionarios;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(ArrayList<Funcionario> Funcionarios) {
        this.Funcionarios = Funcionarios;
    }    
}

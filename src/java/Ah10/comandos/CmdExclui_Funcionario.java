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
public class CmdExclui_Funcionario {
    private String cmd = null;
    private ArrayList<Pis> funcionarios = null; 

    public CmdExclui_Funcionario() {
        this.cmd = "exclui_funcionario";
    }

    /**
     * @return the funcionarios
     */
    public ArrayList<Pis> getFuncionarios() {
        return funcionarios;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(ArrayList<Pis> funcionarios) {
        this.funcionarios = funcionarios;
    }    
}

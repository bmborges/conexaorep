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
    private ArrayList<Pis> Funcionarios = null; 

    public CmdExclui_Funcionario() {
        this.cmd = "exclui_funcionarios";
    }

    /**
     * @return the funcionarios
     */
    public ArrayList<Pis> getFuncionarios() {
        return Funcionarios;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(ArrayList<Pis> Funcionarios) {
        this.Funcionarios = Funcionarios;
    }    
}

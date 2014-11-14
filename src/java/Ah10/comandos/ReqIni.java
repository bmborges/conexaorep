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
public class ReqIni {
    private String req = null;
    private String resp = null;
    private Integer nsr = null;
    private String[] registros = null;

    /**
     * @return the req
     */
    public String getReq() {
        return req;
    }

    /**
     * @param req the req to set
     */
    public void setReq(String req) {
        this.req = req;
    }

    /**
     * @return the resp
     */
    public String getResp() {
        return resp;
    }

    /**
     * @param resp the resp to set
     */
    public void setResp(String resp) {
        this.resp = resp;
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

    /**
     * @return the registros
     */
    public String[] getRegistros() {
        return registros;
    }

    /**
     * @param registros the registros to set
     */
    public void setRegistros(String[] registros) {
        this.registros = registros;
    }
}

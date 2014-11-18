/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ah10.principal;

import Ah10.comandos.CmdAfd;
import Ah10.comandos.CmdDorme;
import Ah10.comandos.CmdNsr;
import Ah10.comandos.CmdStatus;
import Ah10.comandos.ReqIni;
import Ah10.dao.Fpg_Importaponto_AhgoraDao;
import Ah10.dao.Fpg_Ponto_AhgoraDao;
import Ah10.dao.Fpg_Ponto_CmdPendenteDao;
import Ah10.vo.Fpg_Ponto_CmdPendenteVO;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Decoder;

/**
 *
 * @author root
 */
public class ConexaoRep extends HttpServlet {
    List l = new ArrayList<Fpg_Ponto_CmdPendenteVO>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            BASE64Decoder base64Decode = new BASE64Decoder();

            /*Captura o Authorization, nrRep e senhaRep(se passado)*/
            String nrRep = new String(base64Decode.decodeBuffer(request.getHeader("Authorization").replace("Basic", "").trim()));
            String senhaRep = nrRep.split(":")[1];
            nrRep = nrRep.split(":")[0];
            nrRep = Long.parseLong(nrRep) + "";
            
            InputStream is = request.getInputStream();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] buf = new byte[32];
            int r=0;
            while( r >= 0 ) {
                r = is.read(buf);
                if( r >= 0 ) os.write(buf, 0, r);
            }
            String s = new String(os.toByteArray(), "UTF-8");
            s = s.replaceFirst("^[^{]+", "");
            s = s.replaceAll("[^}]+$", "").trim();
            
                        
            Gson gson = new Gson();
            ReqIni ini = new ReqIni();
            CmdDorme dorme = new CmdDorme();
            CmdNsr nsr = new CmdNsr();
            
            ini = gson.fromJson(s, ReqIni.class);
            
            if (ini.getReq().equalsIgnoreCase("ini")){
                System.out.println(Calendar.getInstance().getTime());
                System.out.println("nrRep " + nrRep);
                
                Fpg_Ponto_CmdPendenteDao dao = new Fpg_Ponto_CmdPendenteDao();
                if (l.size() == 0) {
                    System.out.println("Pesquisando Comando(s) Pendente(s) REP " + nrRep);
                    l = dao.VerificaCmdPendente(nrRep);
                    out.println(gson.toJson(nsr));
                } else if (l.size() > 0){
                    System.out.println("Executando Comando(s) Pendente(s)");
                    for (int i = 0; i < l.size(); i++) {
                        Fpg_Ponto_CmdPendenteVO vo = (Fpg_Ponto_CmdPendenteVO) l.get(i);
                        if (vo.getNmcomando().equalsIgnoreCase("exclui_funcionarios")){
                            out.println(gson.toJson(dao.exclui_funcionario(vo)));
                        } else if (vo.getNmcomando().equalsIgnoreCase("cfg_funcionarios")){
                            out.println(gson.toJson(dao.cfg_funcionario(vo)));
                        } else if (vo.getNmcomando().equalsIgnoreCase("pede_dados_pis")){
                            out.println(gson.toJson(dao.pede_dados_pis(vo)));                
                        }
                    }
                    l = new ArrayList<Fpg_Ponto_CmdPendenteVO>();
                }
                
                //out.println("{\"cmd\":\"empresa\"}");
                //out.println("{\"cmd\":\"status\"}");
                //out.println("{\"cmd\":\"pede_dados_PIS\",\"PIS\":\"13634611315\"}");
                //out.println("{\"cmd\":\"lista_PIS\"}");
            } else if (ini.getReq().equalsIgnoreCase("status")){
                // verifica status
                CmdStatus status = new CmdStatus();
                
                status = gson.fromJson(s, CmdStatus.class);
                System.out.println("IP: " + status.getIP());
                System.out.println("Printer: " + status.getPrinter());
                System.out.println("REP: " + status.getREP());
                
                out.println(gson.toJson(dorme));
            } else if (ini.getReq().equalsIgnoreCase("empresa")){
                if (ini.getResp().equalsIgnoreCase("ok")){
                    System.out.println(s);
                    out.println(gson.toJson(dorme));
                }
            } else if (ini.getReq().equalsIgnoreCase("NSR")){
                if (ini.getResp().equalsIgnoreCase("ok")){
                    // verifica ultimo registro rep
                    //System.out.println(s);
                    System.out.println("Pesquisando Batidas REP " + nrRep);
                    Fpg_Ponto_AhgoraDao dao = new Fpg_Ponto_AhgoraDao();
                    CmdAfd afd = new CmdAfd();
                    
                    Integer nsr_ini = dao.UltimoNsr(nrRep);
                    Integer nsr_fim = ini.getNsr();
                    if (nsr_ini == 0){
                        nsr_ini = ini.getNsr();
                    }
                    if (nsr_fim > nsr_ini + 50){
                        nsr_fim = nsr_ini + 50;
                    }
                    afd.setNsr_ini(nsr_ini);
                    afd.setNsr_fim(nsr_fim);
                    if (nsr_fim > nsr_ini){
                        System.out.println(gson.toJson(afd));
                        out.println(gson.toJson(afd));
                    } else {
                        out.println(gson.toJson(dorme));
                    }
                }
                
            } else if (ini.getReq().equalsIgnoreCase("AFD")){    
                if (ini.getResp().equalsIgnoreCase("ok")){
                    // pesquisa registros rep
                    //System.out.println(s);
                    Fpg_Importaponto_AhgoraDao dao = new Fpg_Importaponto_AhgoraDao();
                    if (ini.getRegistros() != null && ini.getRegistros().length > 0){
                        for (int i = 0; i < ini.getRegistros().length; i++) {
                            //grava os pontos coletados
                            System.out.println(ini.getRegistros()[i]);
                            dao.Importar(ini.getRegistros()[i], nrRep);
                        }
                    }
                    out.println(gson.toJson(dorme));
                }
           } else if (ini.getReq().equalsIgnoreCase("cfg_funcionarios")){    
                if (ini.getResp().equalsIgnoreCase("ok")){
                    out.println(gson.toJson(dorme));
                }
           } else if (ini.getReq().equalsIgnoreCase("pede_dados_PIS")){    
                if (ini.getResp().equalsIgnoreCase("ok")){
                    // pesquisa registros dados pelo pis
                    System.out.println(s);
                }                
            } else if (ini.getReq().equalsIgnoreCase("exclui_funcionarios")){ 
                if (ini.getResp().equalsIgnoreCase("ok")){
                    out.println(gson.toJson(dorme));
                } else {
                    System.out.println("Erro ao Executar Comando");
                    System.out.println(s);
                }
            } else {
                System.out.println("Comando não Identificado");
                System.out.println(s);
            }
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ConexaoRep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ConexaoRep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

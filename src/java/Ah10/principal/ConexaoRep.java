/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ah10.principal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            BASE64Decoder base64Decode = new BASE64Decoder();

            /*Captura o Authorization, nrRep e senhaRep(se passado)*/
            String nrRep = new String(base64Decode.decodeBuffer(request.getHeader("Authorization").replace("Basic", "").trim()));
            String senhaRep = nrRep.split(":")[1];
            nrRep = nrRep.split(":")[0];
            nrRep = Long.parseLong(nrRep) + "";
            System.out.println("nrRep " + nrRep);
            
            
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
            
            System.out.println(s);
            System.out.println("");
            
            if (s.contains("ini")){
                //out.println("{\"cmd\":\"empresa\"}");
                out.println("{\"cmd\":\"status\"}");
                //out.println("{\"cmd\":\"pede_dados_PIS\",\"PIS\":\"13634611315\"}");
                //out.println("{\"cmd\":\"lista_PIS\"}");
            }
            if (!s.contains("ini")){
                out.println("{\"cmd\":\"dorme\"}");
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
        processRequest(request, response);
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
        processRequest(request, response);
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

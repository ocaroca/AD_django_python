/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author alumne
 */
@WebServlet(name = "buscarImagen", urlPatterns = {"/buscarImagen"})
public class buscarImagen extends HttpServlet {

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
            
           
           
            String title = request.getParameter("titulo");
            String author = request.getParameter("autor");
            String price = request.getParameter("precio");
            String reserved = "";
            if (request.getParameter("reserved").equals("YES")){
                reserved = "true";
            }
            else if (request.getParameter("reserved").equals("NO")){
                reserved = "false";
            }
            
            
            String paramOrden="";
            String orden = request.getParameter("ordenar");
            if(!orden.equals("BLANK")){
                paramOrden = "ordering=";
                if(orden.equals("desc"))
                    paramOrden += "-";
                String atribOrden = request.getParameter("attribOrdenar");
                    if(!atribOrden.equals("BLANK"))
                paramOrden += atribOrden;
            }
            
            
            
            URL url;
            try {
                
                String urlbuscar = "http://127.0.0.1:8000/imagenes/?" 
                        + "titulo=" + title + "&"
                        + "autor=" + author + "&"
                        + "precio=" + price + "&"
                        + "reservado=" + reserved + "&"
                        + paramOrden;
                
                System.out.println(urlbuscar);
                url = new URL(urlbuscar);
                
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setDoOutput(true);
                con.setRequestProperty("Accept", "application/json");
                con.setRequestProperty("Content-Type", "application/json;utf-8" );
                
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                
                String linea;
                String lista = "";
                while ((linea = in.readLine()) != null) {
                    lista += linea;
                }
                
                try {
                    JSONArray data = new JSONArray(lista);
                    for(int i = 0; i < data.length(); ++i){
                        //Obtener onjeto JSON
                        JSONObject actual = data.getJSONObject(i);
                        //Mostrar Parametros
                        Integer id = actual.getInt("id");
                        String autor = actual.getString("autor");
                        String titulo = actual.getString("titulo");
                        String precio = actual.getString("precio");
                        out.println("Autor: "+ autor + "<br>"+ "Titulo: "+ titulo
                        + "<br>"+ "Precio:"+ precio+ "<br>"
                        +"<form action='delete' method = 'DELETE'>"
                        + "<input type = 'hidden' name = 'id' value ='"+ id + "'>"
                        + "<button type = 'submit'> Eliminar </button>"
                        + "</form>"
                        + "<br>" + "<br>");
                    }
                    
                        
                        
                    
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                //System.out.println(lista);
            } catch(IOException e) {
                System.out.println(e.getMessage());
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

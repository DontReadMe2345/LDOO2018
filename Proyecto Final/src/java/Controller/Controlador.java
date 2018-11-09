/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zenit
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String variable = request.getParameter("varcontrol");
            if ("1".equals(variable)){
                String nombre = request.getParameter("nombre");
                String correo = request.getParameter("correo");
                String pass = request.getParameter("pass");
                Registro r = new Registro();
                r.setNombre(nombre);
                r.setCorreo(correo);
                r.setPass(pass);  
                DataBase db = new DataBase();
                db.getUrl();
                Pedir ask = db.Pedir();
                Add ins = db.Add();
                
                int control = 0;
                try {
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        Connection con = DriverManager.getConnection(db.getUrl(),"admon","admon");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(ask.getSolicitar());
                while(rs.next()) { 
                    int id = rs.getInt("ID");
                    if (id != 10){
                        control = control + 1;
                    } 
                }
                        stmt.executeUpdate(ins.getInsertar() + "VALUES ( "+ control + ",'" + r.getNombre() + "','"+ correo +"', '"+ pass +"')");
                        
                                         
                
                }catch (SQLException e) { 
                        out.println("ERROR: " + e); 
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Controlador</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<fieldset><legend>Su Informacion:</legend><h1>Su nombre es: " + r.getNombre()+"</h1>");
                out.println("<h1>Su correo: " + r.getCorreo()+ "</h1>");
                out.println("<h1>Su password: " + r.getPass() + "</h1>");
                out.println("</fieldset><a href='Login.jsp'>Iniciar Session</a></body>");
                out.println("</html>");
            
            }else if ("2".equals(variable)){
                HttpSession miSession = request.getSession();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Controlador</title>");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Home</title>        <style> \n" +
                            "        body {\n" +
                            "            background-color: black;\n" +
                            "            left: 550px;\n" +
                            "	    top: 25px;\n" +
                            "            color: red;\n" +
                            "            position:relative;\n" +
                            "            width:800px;\n" +
                            "            height:540px;\n" +
                            "\n" +
                            "            font-size: 30px;\n" +
                            "            left: 400px;\n" +
                            "            top: 80px;  \n" +
                            "            font-family: \"Times New Roman\";\n" +
                            "            text-align: center;\n" +
                            "        }\n" +
                            "        </style>");            
                out.println("</head>");                
                out.println("</head>");
                out.println("<body>");
                out.println("<fieldset><legend>Su Informacion:</legend><h1>Su nombre es:<br> " + (String)miSession.getAttribute("name") + " " + (String)miSession.getAttribute("APP") + " " +(String)miSession.getAttribute("APM")+ "</h1>");
                out.println("<h1>Su correo:<br> " + (String)miSession.getAttribute("userid")+ "</h1>");
                out.println("<h1>Su contraseña: <br>" + (String)miSession.getAttribute("passid") + "</h1>");
                out.println("</fieldset><a href='index.html'>Regresar</a></body>");
                out.println("</html>");
                
            }else{
                
                String url = "jdbc:derby://localhost:1527/SuperBase1"; 
                String query = "select * from ROOT.UNTITLED"; 
                String corre = request.getParameter("mail");
                String contra = request.getParameter("contra");
                Validate v = new Validate();
                v.setPass(contra);
                v.setCorreo(corre);
                String nombre1 = null;
               
                try {
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        Connection con = DriverManager.getConnection(url,"admon","admon");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        
                while(rs.next()) { 
                    String vcorreo = rs.getString("CORREO");
                    String vpass = rs.getString("CONTRASEÑA");
                    String nombre = rs.getString("NOMBRE");
                   
             
                    
                    if (vcorreo.equals(corre) && vpass.equals(contra)){
                        v.setVcorreo(vcorreo);
                        v.setVpass(vpass);
                        nombre1= nombre;
                       
                    }
                    } 
                }catch (SQLException e) { 
                        out.println("ERROR: " + e); 
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                v.validar();
                    if (v.getCheck()){
                        HttpSession miSession = request.getSession();
                        miSession.setAttribute("userid", corre);
                        miSession.setAttribute("passid", contra);
                        miSession.setAttribute("name", nombre1);
                       
                        Cookie micookie = new Cookie("Login","Sucess");
                        micookie.setMaxAge(60*60*24);
                        TaconMadre taco = TaconMadre.getInstance();
                        out.println(taco.taconm());
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Home</title>        <style> \n" +
                                    "        body {\n" +
                                    "            background-color: black;\n" +
                                    "            left: 550px;\n" +
                                    "	    top: 25px;\n" +
                                    "            color: red;\n" +
                                    "            position:relative;\n" +
                                    "            width:800px;\n" +
                                    "            height:540px;\n" +
                                    "\n" +
                                    "            font-size: 30px;\n" +
                                    "            left: 400px;\n" +
                                    "            top: 80px;  \n" +
                                    "            font-family: \"Times New Roman\";\n" +
                                    "            text-align: center;\n" +
                                    "        }\n" +
                                    "        </style>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<br>Bienvenido " + nombre1);
                        out.println("<br><a href='index.html'>Cerrar Session</a>");
                        out.println("<br><form action=\"Controlador\" id=\"form\" method=\"post\" > \n" +
                                    "    <input size=\"50\" type=\"hidden\" name=\"varcontrol\" value=\"2\">\n" +
                                    "    <input type=\"submit\" value=\"Perfil\" > \n" +
                                    "</form>");
                        micookie.setMaxAge(0);
                    } else { 
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Home</title>        <style> \n" +
                                    "        body {\n" +
                                    "            background-color: black;\n" +
                                    "            left: 550px;\n" +
                                    "	    top: 25px;\n" +
                                    "            color: red;\n" +
                                    "            position:relative;\n" +
                                    "            width:800px;\n" +
                                    "            height:540px;\n" +
                                    "\n" +
                                    "            font-size: 30px;\n" +
                                    "            left: 400px;\n" +
                                    "            top: 80px;  \n" +
                                    "            font-family: \"Times New Roman\";\n" +
                                    "            text-align: center;\n" +
                                    "        }\n" +
                                    "        </style>");            
                        out.println("</head>");
                        out.println("Correo o Contraseña Incorrecto" + " <br> <a href='Login.jsp'>Intentalo de nuevo</a>"); 
                    }
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
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
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
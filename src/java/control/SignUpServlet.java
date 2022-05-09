/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BankAccount;
import model.DataBaseManager;
import model.UserAccount;
import model.UserData;

/**
 *
 * @author nahimaortega
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {
    private String firstname;
    private String lastname;
    private String dni;
    private String email;

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignUpServlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpServlet1 at " + request.getContextPath() + "</h1>");
            out.println(firstname);
            out.println(lastname);
            out.println(dni);
            out.println(email);
            out.println(request.getParameter("address"));
            out.println(request.getParameter("phone"));
            out.println(request.getParameter("password"));
            out.println("</body>");
            out.println("</html>");
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
        SignUpCommand command = new SignUpCommand();
        command.init(getServletContext(), request, response);
        if (request.getParameter("second-slide").equals("y")) {
            
            try {
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String password = request.getParameter("password");
                HttpSession session = request.getSession(true);
                UserData userData = new UserData(dni, password, firstname, lastname, email, address, phone);
                UserAccount userAccount = new UserAccount(userData);
                session.setAttribute("user", userAccount);
                command.process("'" + firstname + "'", "'" + lastname + "'", "'" + dni + "'",
                        "'" + email + "'", "'" + address + "'", "'" + phone + "'", "'" + password + "'");
            } catch (SQLException ex) {
                Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (request.getParameter("second-slide").equals("n")) {
            firstname = request.getParameter("firstname");
            lastname = request.getParameter("lastname");
            dni = request.getParameter("dni");
            email = request.getParameter("email");
            command.processFirstSlide();
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

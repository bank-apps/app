/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bank;
import model.UserData;

/**
 *
 * @author nahimaortega
 */
public class SignUpCommand {
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.context = context;
        this.request = request;
        this.response = response;
    }
    
    public void processFirstSlide() throws ServletException, IOException {
        forward("/jsp/signup2.jsp");
    }
    
    public void process(String firstname, String lastname, String dni, String email, String address, String phone, String password) throws ServletException, IOException, SQLException, ClassNotFoundException {
        UserData userData = new UserData(dni, password, firstname, lastname, email, address, phone);
        Bank bank = new Bank();
        String registerMessage = bank.register(userData);
        System.out.println(registerMessage);
        if (registerMessage.equals("OK")) {
            forward("/jsp/dashboard.jsp");
        }
        else if (registerMessage.equals("Este usuario ya existe")) {
            forward("/jsp/failedsignup1.jsp");
        }
        else {
            forward("/jsp/failedsignup2.jsp");
        } 
    }
    
    protected void forward(String target) throws ServletException, IOException {
        RequestDispatcher dp = this.context.getRequestDispatcher(target);
        dp.forward(this.request, this.response);
    }
}

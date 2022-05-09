/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bank;
import model.UserAccount;
import model.UserData;
import model.DataBaseManager;

public class LoginCommand {
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.context = context;
        this.request = request;
        this.response = response;
    }
    
    public void process(String dni, String password) throws ServletException, IOException, ClassNotFoundException {
        Bank bank = new Bank();
        String loginResult = bank.login(dni, password);
        if (loginResult.equals("OK")) {
            HttpSession session = request.getSession(true);
            UserData userData = DataBaseManager.SelectUserByDNI(dni);
            UserAccount userAccount = new UserAccount(userData);
            session.setAttribute("user", userAccount);
            forward("/jsp/dashboard.jsp");
        }
        else {
            forward("/jsp/failedlogin.jsp");
        }
    }
    
    protected void forward(String target) throws ServletException, IOException {
        RequestDispatcher dp = this.context.getRequestDispatcher(target);
        dp.forward(this.request, this.response);
    }
}

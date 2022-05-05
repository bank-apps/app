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
import model.Bank;
import model.UserAccount;

/**
 *
 * @author samuel-portatil
 */
public class CreateAccountCommand {
    
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response){
        this.context = context;
        this.request = request;
        this.response = response;
    }
    
    public void process(UserAccount account) throws ClassNotFoundException, Exception{
        Bank bank = new Bank();
        if(bank.AddBankAccount(account).equals("OK")){
            forward("/jsp/viewuseraccount.jsp");
        }else{
            forward("jsp/dashboard.jsp");
        }        
    }
    
    protected void forward(String target) throws ServletException, IOException {
        RequestDispatcher dp = this.context.getRequestDispatcher(target);
        dp.forward(this.request, this.response);
    }
}

package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bank;
import model.BankAccount;
import model.UserData;
import model.DataBaseManager;
import model.UserAccount;

public class CardCommand {
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.context = context;
        this.request = request;
        this.response = response;
    }
    
    public void process() throws ServletException, IOException, ClassNotFoundException {
        HttpSession session = request.getSession(true);
        UserAccount userAccount = (UserAccount)session.getAttribute("user");
        int id = 0;
        id = DataBaseManager.SelectUserId("'" + userAccount.getData().getDNI() + "'");
        if (DataBaseManager.GetCardStatus(id).equals("1")) {
             forward("/jsp/viewcards.jsp");
        }
        else {
            forward("/jsp/addnewcard.jsp");
        }
    }
    
    protected void forward(String target) throws ServletException, IOException {
        RequestDispatcher dp = this.context.getRequestDispatcher(target);
        dp.forward(this.request, this.response);
    }
}
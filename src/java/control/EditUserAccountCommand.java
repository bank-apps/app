package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bank;
import model.DataBaseManager;
import model.UserAccount;
import model.UserData;

public class EditUserAccountCommand {
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    
    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.context = context;
        this.request = request;
        this.response = response;
    }
    
    public void process(String firstname, String lastname, String dni, String email, String address, String phone, String password) throws ServletException, IOException, ClassNotFoundException, Exception {
        Bank bank = new Bank();
        HttpSession session = request.getSession(true);;
        if (!"".equals(request.getParameter("new-password"))) {
            if (! request.getParameter("new-password").equals(request.getParameter("new-password-repeat"))) {
                forward("/jsp/failededituseraccount.jsp");
                return;
            }
            else {
                UserAccount userAccount = (UserAccount)session.getAttribute("user");
                UserData userData = userAccount.getData();
                userData.setPassword(request.getParameter("new-password"));
                userAccount.setData(userData);
                session.setAttribute("user", userAccount);
                
            }
        }
        UserAccount userAccount = (UserAccount)session.getAttribute("user");
        UserData userData = userAccount.getData();
        userData.setName(firstname);
        userData.setSurnames(lastname);
        userData.setEmail(email);
        userData.setAddress(address);
        userData.setPhoneNumber(phone);
        userAccount.setData(userData);
        session.setAttribute("user", userAccount);
        try {
            bank.modifyUserData(userData);
            System.out.println(userData.getName());
            forward("/jsp/viewuseraccount.jsp");
        } catch (Exception e) {
            forward("/jsp/failededituseraccount.jsp");
        }
    }
    
    protected void forward(String target) throws ServletException, IOException {
        RequestDispatcher dp = this.context.getRequestDispatcher(target);
        dp.forward(this.request, this.response);
    }
}

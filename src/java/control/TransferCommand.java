package control;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bank;
import model.BankAccount;
import model.DataBaseManager;
import model.UserAccount;
import model.UserData;

public class TransferCommand {

    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.context = context;
        this.request = request;
        this.response = response;
    }
    
    public void process(UserAccount userAccount, Double amount, String toIBAN, String recipient, String concept) throws ServletException, IOException {
        Bank bank = new Bank();
        UserData userData = userAccount.getData();
        int id = DataBaseManager.SelectUserId("'" + userData.getDNI() + "'");
        String fromIBAN = null;
        if (id != 0) {
            fromIBAN = DataBaseManager.SelectIBANWithID(id);
        } else {
            forward("/jsp/transfer.jsp");
        }
        BankAccount from = new BankAccount(fromIBAN);
        from.setBalance(DataBaseManager.SelectBalanceWithIBAN(fromIBAN));
        BankAccount to = new BankAccount(toIBAN);
        to.setBalance(DataBaseManager.SelectBalanceWithIBAN(toIBAN));
        
        String result = bank.transfer(from, to, recipient, amount, concept);
        if (result.equals("OK")) {
            forward("/jsp/dashboard.jsp");
        } else {
            forward("/jsp/transfer.jsp");
        }
    }

    protected void forward(String target) throws ServletException, IOException {
        RequestDispatcher dp = this.context.getRequestDispatcher(target);
        dp.forward(this.request, this.response);
    }
}

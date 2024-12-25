package com.GinElmaC.bank.web;

import com.GinElmaC.bank.MyException.NoMoneyException;
import com.GinElmaC.bank.MyException.TransferException;
import com.GinElmaC.bank.Util.SqlSessionUtil;
import com.GinElmaC.bank.service.AccountService;
import com.GinElmaC.bank.service.Impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    //为了让这个对象在其他方法中也可以使用，声明为实例变量
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //从前段表单获取数据
        String fromActno = req.getParameter("fromActno");
        String toActno = req.getParameter("toActno");
        String moneyString = req.getParameter("money");
        Double money = Double.parseDouble(moneyString);
        //servlet实际上是不处理业务逻辑的，要调用service包中的业务逻辑方法
        //调用业务
        try {
            accountService.transfer(fromActno,toActno,money);
            //调用View层（MVC架构中的）展示结果
            resp.sendRedirect(req.getContextPath()+"/success.html");
        } catch (NoMoneyException e) {
            resp.sendRedirect(req.getContextPath()+"/nomoney.html");
            throw new RuntimeException(e);
        } catch (TransferException e) {
            resp.sendRedirect(req.getContextPath()+"/transferException.html");
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
        }


    }
}

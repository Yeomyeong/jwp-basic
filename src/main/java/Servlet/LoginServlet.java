package Servlet;

import db.DataBase;
import model.User;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wymstar on 7/7/16.
 */
@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        String pw = req.getParameter("password");


        User user = DataBase.findUserById(id);
        if (user != null) {
            if (user.getPassword().equals(pw)) {
                Cookie cookie = new Cookie("logined", "true");
                resp.addCookie(cookie);
                resp.sendRedirect("/index.html");
                return ;
            }
        }
        resp.sendRedirect("/user/login_failed.html");

    }
}

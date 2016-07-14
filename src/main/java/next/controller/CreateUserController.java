package next.controller;

import core.db.DataBase;
import next.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wymstar on 7/11/16.
 */
public class CreateUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User(
                request.getParameter("userId"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("email"));
        log.debug("User : {}", user);

        DataBase.addUser(user);

        return "redirect:/";
    }
}

package next.controller;

import next.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wymstar on 7/11/16.
 */
public class ForwordController implements Controller {
    private String forwordPath;

    public ForwordController(String forwordPath) {
        this.forwordPath = forwordPath;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return forwordPath;
    }
}

package core.mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wymstar on 7/18/16.
 */
public class JSPView implements View {

    private String jsppath;

    public JSPView(String jsppath) {
        this.jsppath = jsppath;
    }

    @Override
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(jsppath);
        rd.forward(request, response);
    }
}

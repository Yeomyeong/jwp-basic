package core.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wymstar on 7/18/16.
 */
public class RedirectView implements View {

    private String redirectUrl;

    public RedirectView(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(redirectUrl);
    }
}

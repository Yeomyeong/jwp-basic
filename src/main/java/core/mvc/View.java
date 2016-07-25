package core.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wymstar on 7/18/16.
 */
public interface View {
    void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

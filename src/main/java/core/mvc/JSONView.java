package core.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wymstar on 7/18/16.
 */
public class JSONView implements View{
    private Object convertableObject;

    public JSONView(Object convertableObject) {
        this.convertableObject = convertableObject;
    }

    public JSONView(HttpServletRequest request) {
        this.convertableObject = toModel(request);
    }

    @Override
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(mapper.writeValueAsString(convertableObject));
    }

    private Object toModel(HttpServletRequest request) {
        Enumeration<String> names = request.getAttributeNames();
        Map<String, Object> model = new HashMap<>();

        while(names.hasMoreElements()) {
            String name = names.nextElement();
            model.put(name, request.getAttribute(name));
        }
        return model;
    }
}
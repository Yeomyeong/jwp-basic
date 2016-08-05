package next.controller;

import core.annotation.Controller;
import core.annotation.RequestMapping;
import core.mvc.AbstractController;
import core.mvc.JsonView;
import core.mvc.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wymstar on 8/1/16.
 */
@Controller
public class AnnotationTestController{

    @RequestMapping(value = "/anno/test")
    public ModelAndView test(HttpServletRequest req, HttpServletResponse resp) {

        ModelAndView view = new ModelAndView(new JsonView());
        view.addObject("nike", "kkkk");

        return view;
    }
}

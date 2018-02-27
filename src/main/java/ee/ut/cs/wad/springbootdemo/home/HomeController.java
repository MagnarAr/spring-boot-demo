package ee.ut.cs.wad.springbootdemo.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private static final String TEMPLATE_GREETING = "home/greeting";

    @RequestMapping(path = "/greeting", method = RequestMethod.GET)
    public String greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return TEMPLATE_GREETING;
    }

}

package team11.project.behaviorapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by c1443907 on 17/11/2017.
 */

@Controller
public class TemplateController {

    @RequestMapping(path = "/gp/index")
    public String index(){
        return "index";
    }
}

package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {
    @GetMapping("/start")
    public String greeting(Map<String, Object> model) {
        return "start";
    }
}

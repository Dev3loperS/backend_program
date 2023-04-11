package cybersoft.java20.dev3lopers.gear3sproject.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping("/admin")
public class AdThymeleafController {

    @GetMapping("/home")
    public String getHomePage(Model model) {
        return "pages/admin-home";
    }

    @GetMapping("/users")
    public String getUsersPage(Model model) {
        return "pages/admin-users";
    }
}

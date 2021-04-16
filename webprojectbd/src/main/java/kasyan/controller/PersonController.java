package kasyan.controller;


import kasyan.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

    private PersonService personService;

    @GetMapping(value = "/startlogin")
    public String startLogin() {
        return "index";
    }

    @PostMapping(value = "/startlogin")
    public ModelAndView startLoginPost(@RequestParam(value = "login") String login,
                                       @RequestParam(value = "password") String password) {

        if (personService.verificationOfAuthenticity(login, password)) {
            return new ModelAndView("redirect:currentlogin");
        }
        return new ModelAndView("redirect:nocurrentlogin");
    }

    @GetMapping(value = "/currentlogin")
    public String currentlogin() {
        return "currentlogin";
    }

    @GetMapping(value = "/nocurrentlogin")
    public String nocurrentlogin() {
        return "nocurrentlogin";
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

}

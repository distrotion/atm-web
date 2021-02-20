package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    @GetMapping
    public String getCustomerPage(Model model){

        return "bankaccount";  // bankaccount in resource/templates
    }
}

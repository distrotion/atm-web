package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.model.Customer;
import th.ac.ku.atm.service.BankAccountService;
import th.ac.ku.atm.service.CustomerService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private CustomerService customerService;
    private BankAccountService bankAccountService;

    public BankAccountController(CustomerService customerService, BankAccountService bankAccountService) {
        this.customerService = customerService;
        this.bankAccountService = bankAccountService;
    }


    @GetMapping
    public String getCustomerPage(Model model){
        model.addAttribute("allAccount",bankAccountService.getAccount());
        return "bankaccount";  // bankaccount in resource/templates
    }

    @PostMapping
    public String registerCustomer(@ModelAttribute BankAccount customer, Model model) {
        Customer matchingCustomer = customerService.findCustomer(customer.getId());
        //bankAccountService.createAccount(customer);
        if(matchingCustomer != null){
            bankAccountService.createAccount(customer);
            model.addAttribute("allAccount", bankAccountService.getAccount());
        }else {
            model.addAttribute("greeting", "Can't find customer");
            return "home";
        }


        return "redirect:bankaccount";
    }

}

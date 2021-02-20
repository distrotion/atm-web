package th.ac.ku.atm.service;

import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {

    private ArrayList<BankAccount> bankAccountsList = new ArrayList<>();

    public void createAccount(BankAccount bankAccount){
        bankAccountsList.add(bankAccount);
    }

    public List<BankAccount> getAccount(){
        return new ArrayList<>(bankAccountsList);
    }
}

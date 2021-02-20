package th.ac.ku.atm.service;

import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {

    private ArrayList<BankAccount> bankAccountsList = new ArrayList<>();

    public void createAccount(BankAccount bankAccount){
        BankAccount storedBankAccount = findBankAccount(bankAccount.getId());
        if(storedBankAccount == null){
            bankAccountsList.add(bankAccount);
        }

    }

    public List<BankAccount> getAccount(){

        return new ArrayList<>(bankAccountsList);
    }

    public BankAccount findBankAccount(int id) {
        for (BankAccount account : bankAccountsList) {
            if (account.getId() == id)
                return account;
        }
        return null;
    }
}

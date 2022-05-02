
import java.util.HashMap;



/*
 * Copyright 2022 DucPTMHE160517
 */

/**
 *
 * @author DucPTMHE160517
 */
class AccountList {
    HashMap <String, String> accountList;
    
    AccountList() {
        accountList = getInitializationAccount();
    }
    
    AccountList(HashMap <String, String> accountList) {
        this.accountList = accountList;
    }
    
    final HashMap <String, String> getInitializationAccount() {
        HashMap <String, String> accountDatabase = new HashMap <>();
        
        accountDatabase.put("0123456789", "123456ab");
        accountDatabase.put("1628162828", "weareone2");
        accountDatabase.put("2202202222", "2000plus22");
        
        return accountDatabase;
    }
    
    private boolean checkAccountNumber(String checkingAccount) {
        
        //Check if account list contains key same as checking account
        if (accountList.containsKey(checkingAccount)) {
            return true;
        }
        
        return false;
    }
    
    private boolean checkPassword(String validAccount, String checkingPassword) {
        String validPassword = accountList.get(validAccount);
        
        //Check if checking password equals valid password
        if (checkingPassword.equals(validPassword)) {
            return true;
        }
        
        return false;
    }
    
    boolean isValidInformation(String checkingAccount, String checkingPassword) {
        
        //Check if check account number is true  when passing checking account
        if (checkAccountNumber(checkingAccount)) {
            
            //Check if check password is true when passing checking account and password
            if (checkPassword(checkingAccount, checkingPassword)) {
                return true;
            }
        }
        
        return false;
    }
    
}
